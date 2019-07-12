package com.qf.web;

import com.github.pagehelper.PageInfo;
import com.qf.bean.AirQualityIndex;
import com.qf.bean.District;
import com.qf.service.AirQualityIndexService;
import com.qf.util.PageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * ** 程序猿
 * 一入代码深似海，
 * 小试牛刀异常来。
 * 奈何BUG直挠耳，
 * 仰天大笑出门来。
 */
@Controller
public class AirQualityIndexController {
    @Resource
    private AirQualityIndexService airService;

    @RequestMapping("selectall")
    public String findall(ModelMap map,@RequestParam(defaultValue = "-1") int did,
                          @RequestParam(defaultValue = "1") int index){
        PageInfo<AirQualityIndex> info = airService.findall(did, index, PageUtils.SIZE);
        List<District> districts = airService.findall();
        map.addAttribute("info",info);
        map.addAttribute("did",did);
        map.addAttribute("dlist",districts);
        return "show";
    }

    @RequestMapping("finddistrict")
    public String finddistrict(ModelMap map){
        List<District> list = airService.findall();
        map.addAttribute("dlist",list);
        return "add";
    }
    @RequestMapping("add")
    public void add(AirQualityIndex airQualityIndex, HttpServletResponse resp){
        airQualityIndex.setLastModifyTime(new Date());
        int i = airService.insertSelective(airQualityIndex);
        try {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            if (i>0){
                out.print("<script>alert('添加成功');location.href='selectall'</script>");
            }else{
                out.print("<script>alert('添加失败');location.href='finddistrict'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("findair")
    public String findair(int id,ModelMap map){
        AirQualityIndex airQualityIndex = airService.selectByPrimaryKey(id);
        List<District> districts = airService.findall();
        map.addAttribute("air",airQualityIndex);
        map.addAttribute("dis",districts);
        return "update";
    }

    @RequestMapping("update")
    public void update(AirQualityIndex air,HttpServletResponse resp){
        air.setLastModifyTime(new Date());
        int i = airService.updateByPrimaryKeySelective(air);
        try {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            if (i>0){
                out.print("<script>alert('更新成功');location.href='selectall'</script>");
            }else{
                out.print("<script>alert('更新失败');location.href='findair?id="+air.getId()+"'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("delete")
    public void delete(int id,HttpServletResponse resp){
        int i = airService.deleteByPrimaryKey(id);
        try {
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            if (i>0){
                out.print("<script>alert('删除成功');location.href='selectall'</script>");
            }else{
                out.print("<script>alert('删除失败');location.href='findair?id="+id+"'</script>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
