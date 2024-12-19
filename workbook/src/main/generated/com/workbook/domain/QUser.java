package com.workbook.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1729837394L;

    public static final QUser user = new QUser("user");

    public final com.workbook.domain.common.QBaseEntity _super = new com.workbook.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<com.workbook.domain.enums.Gender> gender = createEnum("gender", com.workbook.domain.enums.Gender.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final EnumPath<com.workbook.domain.enums.Role> role = createEnum("role", com.workbook.domain.enums.Role.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<com.workbook.domain.mapping.UserAgree, com.workbook.domain.mapping.QUserAgree> userAgreements = this.<com.workbook.domain.mapping.UserAgree, com.workbook.domain.mapping.QUserAgree>createList("userAgreements", com.workbook.domain.mapping.UserAgree.class, com.workbook.domain.mapping.QUserAgree.class, PathInits.DIRECT2);

    public final ListPath<com.workbook.domain.mapping.UserFoodCategory, com.workbook.domain.mapping.QUserFoodCategory> userFoodCategories = this.<com.workbook.domain.mapping.UserFoodCategory, com.workbook.domain.mapping.QUserFoodCategory>createList("userFoodCategories", com.workbook.domain.mapping.UserFoodCategory.class, com.workbook.domain.mapping.QUserFoodCategory.class, PathInits.DIRECT2);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

