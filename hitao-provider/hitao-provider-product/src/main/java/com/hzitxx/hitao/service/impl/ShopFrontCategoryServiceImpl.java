package com.hzitxx.hitao.service.impl;

import com.hzitxx.hitao.commons.ServerResponse;
import com.hzitxx.hitao.entity.ShopFrontCategory;
import com.hzitxx.hitao.front.product.CategoryVo;
import com.hzitxx.hitao.mapper.ShopFrontCategoryMapper;
import com.hzitxx.hitao.service.ShopFrontCategoryService;
import com.hzitxx.hitao.rpc.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-13
 */
@Service
public class ShopFrontCategoryServiceImpl implements ShopFrontCategoryService {

    @Autowired
    private ShopFrontCategoryMapper mapper;

    @Autowired
    private MemberService memberService;
    @Override
    public int addShopFrontCategory(ShopFrontCategory shopFrontCategory){
        return mapper.addShopFrontCategory(shopFrontCategory);
    }

    @Override
    public int addShopFrontCategorySelective(ShopFrontCategory shopFrontCategory){
        return mapper.addShopFrontCategorySelective(shopFrontCategory);
    }

    @Override
    public int deleteById(int frontCatId){
            return mapper.deleteById(frontCatId);
    }

    @Override
    public int deleteByIds(String[]ids){
        return mapper.deleteByIds(ids);
    }
    @Override
    public  int updateById(ShopFrontCategory shopFrontCategory){
        return mapper.updateById(shopFrontCategory);
    }

    @Override
    public  int updateSelectiveById(ShopFrontCategory shopFrontCategory){
        return mapper.updateSelectiveById(shopFrontCategory);
    }

    @Override
    public ServerResponse searchShopFrontCategory(Map<String, Object> map){
        Map<String,Object> resultMap = new HashMap<>();
        List<ShopFrontCategory> frontCategories = mapper.searchShopFrontCategory(map);
        resultMap.put("category",frontCategories);//封装了一级类目
        //封装二级和三级类目数据
        List<CategoryVo> categoryVos = new ArrayList<>();
        resultMap.put("categoryContent",this.categoryVoList(categoryVos,
                frontCategories.get(0).getFrontCatId(),
                2));
        return ServerResponse.createBySuccess(resultMap);
    }

    @Override
    public ServerResponse currentCategory(Integer parentId) {
        List<CategoryVo> categoryVos = new ArrayList<>();
        return ServerResponse.createBySuccess(this.categoryVoList(categoryVos,parentId,2));
    }

    /**
     * 类目
     * @param categoryVos  list集合
     * @param parentId 父级编号
     * @param level 级别
     * @return
     */
   private List<CategoryVo> categoryVoList(List<CategoryVo> categoryVos,Integer parentId,Integer level){
       CategoryVo categoryVo = null;
       Map<String,Object> paramsMap = new HashMap<>();
       paramsMap.put("parentId",parentId);
       List<ShopFrontCategory> frontCategories = mapper.searchShopFrontCategory(paramsMap);
       if(frontCategories!= null){
           for(ShopFrontCategory frontCategory : frontCategories){
               categoryVo = new CategoryVo();
               categoryVo.setCatName(frontCategory.getCatName());
               //拼接三级类目
               paramsMap.put("parentId",frontCategory.getFrontCatId());
               List<ShopFrontCategory> shopFrontCategoryList = mapper.searchShopFrontCategory(paramsMap);
               categoryVo.setChildrens(shopFrontCategoryList);
               categoryVos.add(categoryVo);
           }
       }
       return categoryVos;
   }
    /**
     * 根据id查询数据
     * @param frontCatId
     * @return
     */
    @Override
    public ShopFrontCategory findOne(Integer frontCatId){
            return mapper.findOne(frontCatId);
     }
}

