package jp.co.internous.ocean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import jp.co.internous.ocean.model.domain.MstProduct;
import jp.co.internous.ocean.model.mapper.MstProductMapper;
import jp.co.internous.ocean.model.session.LoginSession;

@Controller
@RequestMapping("/ocean/product")
public class ProductController {

	@Autowired
	private LoginSession loginSession;
	
	@Autowired
     MstProductMapper mstProductMapper;

    @RequestMapping("/{id}")
    public String index(@PathVariable("id") int id, Model m){

	 //商品情報を取得
      List<MstProduct> mstProductList = mstProductMapper.findById(id);
      m.addAttribute("MstProductList",mstProductList);
      m.addAttribute("loginSession",loginSession);
      
      return "product_detail";
   }
}