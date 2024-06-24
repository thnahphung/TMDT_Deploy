package com.TMDT.api.Api.springboot.mapper;

import com.TMDT.api.Api.springboot.dto.ProductDTO;
import com.TMDT.api.Api.springboot.models.Image;
import com.TMDT.api.Api.springboot.models.Product;
import com.TMDT.api.Api.springboot.models.ProductPhoneCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-24T21:45:02+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDTO(Product productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        ProductDTO productDTO1 = new ProductDTO();

        productDTO1.setId( productDTO.getId() );
        productDTO1.setName( productDTO.getName() );
        productDTO1.setDescription( productDTO.getDescription() );
        productDTO1.setPrice( productDTO.getPrice() );
        productDTO1.setDiscount( productDTO.getDiscount() );
        productDTO1.setQuantity( productDTO.getQuantity() );
        productDTO1.setSold( productDTO.getSold() );
        productDTO1.setCreateAt( productDTO.getCreateAt() );
        List<Image> list = productDTO.getImages();
        if ( list != null ) {
            productDTO1.setImages( new ArrayList<Image>( list ) );
        }
        productDTO1.setCategory( productDTO.getCategory() );
        productDTO1.setStatus( productDTO.getStatus() );
        List<ProductPhoneCategory> list1 = productDTO.getProductPhoneCategories();
        if ( list1 != null ) {
            productDTO1.setProductPhoneCategories( new ArrayList<ProductPhoneCategory>( list1 ) );
        }

        return productDTO1;
    }

    @Override
    public Product productDTOtoProduct(ProductDTO product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        product1.setId( product.getId() );
        product1.setName( product.getName() );
        product1.setDescription( product.getDescription() );
        product1.setPrice( product.getPrice() );
        product1.setDiscount( product.getDiscount() );
        product1.setQuantity( product.getQuantity() );
        product1.setSold( product.getSold() );
        product1.setCreateAt( product.getCreateAt() );
        List<Image> list = product.getImages();
        if ( list != null ) {
            product1.setImages( new ArrayList<Image>( list ) );
        }
        product1.setCategory( product.getCategory() );
        product1.setStatus( product.getStatus() );
        List<ProductPhoneCategory> list1 = product.getProductPhoneCategories();
        if ( list1 != null ) {
            product1.setProductPhoneCategories( new ArrayList<ProductPhoneCategory>( list1 ) );
        }

        return product1;
    }
}
