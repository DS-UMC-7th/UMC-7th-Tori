package com.workbook.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserFoodCategory is a Querydsl query type for UserFoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserFoodCategory extends EntityPathBase<UserFoodCategory> {

    private static final long serialVersionUID = 1187464042L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserFoodCategory userFoodCategory = new QUserFoodCategory("userFoodCategory");

    public final com.workbook.domain.common.QBaseEntity _super = new com.workbook.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final com.workbook.domain.QFoodCategory foodCategory;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final com.workbook.domain.QUser user;

    public final NumberPath<Long> user_foodcategory_id = createNumber("user_foodcategory_id", Long.class);

    public QUserFoodCategory(String variable) {
        this(UserFoodCategory.class, forVariable(variable), INITS);
    }

    public QUserFoodCategory(Path<? extends UserFoodCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserFoodCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserFoodCategory(PathMetadata metadata, PathInits inits) {
        this(UserFoodCategory.class, metadata, inits);
    }

    public QUserFoodCategory(Class<? extends UserFoodCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new com.workbook.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.user = inits.isInitialized("user") ? new com.workbook.domain.QUser(forProperty("user")) : null;
    }

}

