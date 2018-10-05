package com.hqjin.tmall.util;

public class Page {
    private int start;
    private int count;
    private int total;
    String param;
    private static final int defaultCount=5;
    public Page(){
        count=defaultCount;
    }
    public Page(int start,int count){
        this();
        this.start=start;
        this.count=count;
    }
    public void setStart(int start){
        this.start=start;
    }
    public int getStart(){
        return start;
    }
    public void setCount(int count){
        this.count=count;
    }
    public int getCount(){
        return count;
    }
    public void setTotal(int total){
        this.total=total;
    }
    public int getTotal(){
        return total;
    }
    public void setParam(String param){
        this.param=param;
    }
    public String getParam(){
        return param;
    }
    public int getLast(){
        int last;
        if(0==total%count){
            last=total-count;
        }
        else
            last=total-total%count;
        last=(last<0)?0:last;
        return last;
    }
    public int getTotalPage(){
        int totalPage;
        return (totalPage=total/count+(total%count==0?0:1))==0?1:totalPage;
    }
    public boolean isHasPrevious(){
        return start==0?false:true;
    }
    public boolean isHasNext(){
        return start==getLast()?false:true;
    }
    @Override
    public String toString(){
        return "Page [start="+start+",count="+count+",total="+total+",getStart()="+getStart()
                +",getCount()="+getCount()+",isHasPrevious()="+isHasPrevious()
                +",isHasNext()="+isHasNext()+",getTotalPage()="+getTotalPage()
                +",getLast()="+getLast()+"]";
    }
}
