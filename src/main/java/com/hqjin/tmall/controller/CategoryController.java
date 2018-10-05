package com.hqjin.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjin.tmall.pojo.Category;
import com.hqjin.tmall.service.CategoryService;
import com.hqjin.tmall.util.ImageUtil;
import com.hqjin.tmall.util.Page;
import com.hqjin.tmall.util.UploadedImageFile;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping("admin_category_list")
    public String list(Model model,Page page){
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Category> cs=categoryService.list();//初始的Page的start=0,count=0,total=0
        int total=(int)new PageInfo<>(cs).getTotal();
        page.setTotal(total);
        model.addAttribute("cs",cs);
        model.addAttribute("page",page);
        return "admin/listCategory";
    }
    @RequestMapping("admin_category_add")
    public String add(Category c, HttpSession session,
                      UploadedImageFile uploadedImageFile) throws IOException{
        System.out.println(c.getId());
        System.out.println(c.getName());
        categoryService.add(c);//category被加进DB后，它的id会自动递增并更新进来。
        System.out.println(c.getId());
        File imageFolder=new File(session.getServletContext().getRealPath("img/category"));
        File file=new File(imageFolder,c.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        System.out.println(uploadedImageFile);
        System.out.println(uploadedImageFile.getImage());
        System.out.println(file);
        uploadedImageFile.getImage().transferTo(file);
        BufferedImage img=ImageUtil.change2jpg(file);
        ImageIO.write(img,"jpg",file);
        return "redirect:/admin_category_list";
    }
    @RequestMapping("admin_category_delete")
    public String delete(int id,HttpSession session) throws IOException{
        categoryService.delete(id);
        File imageFolder=new File(session.getServletContext().getRealPath("img/category"));
        File file=new File(imageFolder,id+".jpg");
        file.delete();
        return "redirect:/admin_category_list";
    }
    @RequestMapping("admin_category_edit")
    public String edit(int id,Model model){
        Category c=categoryService.get(id);
        model.addAttribute("c",c);
        return "admin/editCategory";
    }
    @RequestMapping("admin_category_update")
    public String update(Category c,HttpSession session,UploadedImageFile uploadedImageFile) throws IOException{
        categoryService.update(c);
        MultipartFile image=uploadedImageFile.getImage();
        if(null!=image&&!image.isEmpty()){
            File imageFolder=new File(session.getServletContext().getRealPath("img/category"));
            File file=new File(imageFolder,c.getId()+".jpg");
            image.transferTo(file);//图片改个名字?
            BufferedImage img=ImageUtil.change2jpg(file);//file转成一个为jpg的img
            ImageIO.write(img,"jpg",file);//又把img转成file？
        }
        return "redirect:/admin_category_list";
    }
}
