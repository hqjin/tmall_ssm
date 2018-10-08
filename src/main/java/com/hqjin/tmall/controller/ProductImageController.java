package com.hqjin.tmall.controller;

import com.hqjin.tmall.mapper.ProductMapper;
import com.hqjin.tmall.pojo.Product;
import com.hqjin.tmall.pojo.ProductImage;
import com.hqjin.tmall.service.ProductImageService;
import com.hqjin.tmall.service.ProductService;
import com.hqjin.tmall.util.ImageUtil;
import com.hqjin.tmall.util.UploadedImageFile;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.lang.reflect.Field;

@Controller
@RequestMapping("")
public class ProductImageController {
    @Autowired
    ProductImageService productImageService;
    @Autowired
    ProductService productService;
    @RequestMapping("admin_productImage_add")
    public String add(ProductImage pi, HttpSession session, UploadedImageFile uploadedImageFile){
        productImageService.add(pi);
        String fileName=pi.getId()+".jpg";
        String imageFolder;
        String imageFolder_small=null;
        String imageFolder_middle=null;
        if(ProductImageService.type_single.equals(pi.getType())){
            imageFolder=session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small=session.getServletContext().getRealPath("img/productSingle_small");
            imageFolder_middle=session.getServletContext().getRealPath("img/productSingle_middle");
        }
        else{
            imageFolder=session.getServletContext().getRealPath("img/productDetail");
        }
        File f=new File(imageFolder,fileName);
        f.getParentFile().mkdirs();
        try{
            uploadedImageFile.getImage().transferTo(f);
            BufferedImage img= ImageUtil.change2jpg(f);
            ImageIO.write(img,"jpg",f);

            if(ProductImageService.type_single.equals(pi.getType())){
                File f_small=new File(imageFolder_small,fileName);
                File f_middle=new File(imageFolder_middle,fileName);
                ImageUtil.resizeImage(f,56,56,f_small);
                ImageUtil.resizeImage(f,217,190,f_middle);
            }
        }catch(Exception e){
                e.printStackTrace();
        }
        return "redirect:admin_productImage_list?pid="+pi.getPid();
    }
    @RequestMapping("admin_productImage_delete")
    public String delete(int id, HttpSession session){
        ProductImage pi=productImageService.get(id);
        String fileName=id+".jpg";
        String imageFolder=null;
        String imageFolder_small=null;
        String imageFolder_middle=null;
        if(ProductImageService.type_single.equals(pi.getType())){
            imageFolder=session.getServletContext().getRealPath("img/productSingle");
            imageFolder_small=session.getServletContext().getRealPath("img/productSingle_small");
            imageFolder_middle=session.getServletContext().getRealPath("img/productSingle_middle");
            File imageFile=new File(imageFolder,fileName);
            File f_small=new File(imageFolder_small,fileName);
            File f_middle=new File(imageFolder_middle,fileName);
            imageFile.delete();
            f_small.delete();
            f_middle.delete();
        }
        else{
            imageFolder=session.getServletContext().getRealPath("img/productDetail");
            File imageFile=new File(imageFolder,fileName);
            imageFile.delete();
        }
        productImageService.delete(id);
        return "redirect:admin_productImage_list?pid="+pi.getPid();
    }
    @RequestMapping("admin_productImage_list")
    public String list(int pid, Model model){
        Product p=productService.get(pid);
        List pisSingle=productImageService.list(pid,ProductImageService.type_single);
        List pisDetail=productImageService.list(pid,ProductImageService.type_detail);
        model.addAttribute("p",p);
        model.addAttribute("pisSingle",pisSingle);
        model.addAttribute("pisDetail",pisDetail);
        return "admin/listProductImage";
    }
}
