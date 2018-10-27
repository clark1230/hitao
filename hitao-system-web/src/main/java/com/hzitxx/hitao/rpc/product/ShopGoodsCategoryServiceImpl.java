package com.hzitxx.hitao.rpc.product;

/**
 * <p>
 * 商品分类表 服务实现类
 * </p>
 *
 * @author xianyaoji
 * @since 2018-02-05
 */
//@Service
public class ShopGoodsCategoryServiceImpl implements ShopGoodsCategoryService {
//
//    @Autowired(required = false)
//    private ShopGoodsCategoryMapper mapper;
//
//    @Override
//    public int addShopGoodsCategory(ShopGoodsCategory shopGoodsCategory) {
//        return mapper.addShopGoodsCategory(shopGoodsCategory);
//    }
//
//    @Override
//    public int addShopGoodsCategorySelective(ShopGoodsCategory obj) {
//        return mapper.addShopGoodsCategorySelective(obj);
//    }
//
//    public int deleteById(int gcId) {
//        return mapper.deleteById(gcId);
//    }
//
//
//    public int deleteByIds(String[] ids) {
//        return mapper.deleteByIds(ids);
//    }
//
//    public int updateById(ShopGoodsCategory shopGoodsCategory) {
//        return mapper.updateById(shopGoodsCategory);
//    }
//
//    @Override
//    public int updateSelectiveById(ShopGoodsCategory shopGoodsCategory) {
//        return mapper.updateSelectiveById(shopGoodsCategory);
//    }
//
//
//    public List<ShopGoodsCategory> searchShopGoodsCategory(Map<String, Object> map) {
//        return mapper.searchShopGoodsCategory(map);
//    }
//
//
//    /**
//     * 数据查询分页
//     *
//     * @param page
//     * @param limit
//     * @param map
//     * @return
//     */
//    @Override
//    public LayuiEntity<ShopGoodsCategory> page(int page, int limit, Map<String, Object> map) {
//        PageHelper.startPage(page, limit);
//        List<ShopGoodsCategory> obj = mapper.searchShopGoodsCategory(map);
//        PageInfo<ShopGoodsCategory> pageInfo = new PageInfo<>(obj);
//        LayuiEntity<ShopGoodsCategory> layuiEntity = new LayuiEntity<>();
//        layuiEntity.setCode(0);
//        layuiEntity.setMsg("数据");
//        layuiEntity.setCount(pageInfo.getTotal());
//        layuiEntity.setData(pageInfo.getList());
//        return layuiEntity;
//    }
//
//    /**
//     * 根据id查询数据
//     *
//     * @param gcId
//     * @return
//     */
//    @Override
//    public ShopGoodsCategory findOne(Integer gcId) {
//        return mapper.findOne(gcId);
//    }
//
//    /**
//     * 类目信息
//     *
//     * @return
//     */
//    @Override
//    public ServerResponse ajaxCate() {
//        List<ShopGoodsCategoryVo> list = new ArrayList<>();
//        this.findParentCate(list,0);
//        return ServerResponse.createBySuccess(list);
//    }
//
//    /**
//     * 递归封装类目信息
//     * @param list
//     * @param parentId
//     * @return
//     */
//    private List<ShopGoodsCategoryVo> findParentCate(List<ShopGoodsCategoryVo> list,int parentId){
//        List<ShopGoodsCategory> goodsCategories = this.mapper.findByPId(parentId);
//        ShopGoodsCategoryVo categoryVo = null;
//        if(goodsCategories!= null && goodsCategories.size() >0){
//            for(ShopGoodsCategory gc: goodsCategories){
//                categoryVo = new ShopGoodsCategoryVo();
//                categoryVo.setValue(gc.getCatId());
//                categoryVo.setLabel(gc.getCatName());
//                list.add(categoryVo);
//                categoryVo.setChildren(findParentCate(new ArrayList<ShopGoodsCategoryVo>(),gc.getCatId()));//递归查询自己类目信息
//            }
//        }else{
//            return null;
//        }
//        return list;
//    }
}

