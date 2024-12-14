package com.workbook.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QRestaurantCategory is a Querydsl query type for RestaurantCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurantCategory extends EntityPathBase<RestaurantCategory> {

    private static final long serialVersionUID = -268275458L;

    public static final QRestaurantCategory restaurantCategory = new QRestaurantCategory("restaurantCategory");

    public final com.workbook.domain.common.QBaseEntity _super = new com.workbook.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath name = createString("name");

    public final NumberPath<Long> restaurantcategory_id = createNumber("restaurantcategory_id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRestaurantCategory(String variable) {
        super(RestaurantCategory.class, forVariable(variable));
    }

    public QRestaurantCategory(Path<? extends RestaurantCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRestaurantCategory(PathMetadata metadata) {
        super(RestaurantCategory.class, metadata);
    }

}

