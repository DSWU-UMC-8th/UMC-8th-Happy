package com.dna.umc_springboot.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTerms is a Querydsl query type for Terms
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTerms extends EntityPathBase<Terms> {

    private static final long serialVersionUID = -605656428L;

    public static final QTerms terms = new QTerms("terms");

    public final com.dna.umc_springboot.domain.common.QBaseEntity _super = new com.dna.umc_springboot.domain.common.QBaseEntity(this);

    public final StringPath body = createString("body");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<com.dna.umc_springboot.domain.mapping.MemberAgree, com.dna.umc_springboot.domain.mapping.QMemberAgree> memberAgreeList = this.<com.dna.umc_springboot.domain.mapping.MemberAgree, com.dna.umc_springboot.domain.mapping.QMemberAgree>createList("memberAgreeList", com.dna.umc_springboot.domain.mapping.MemberAgree.class, com.dna.umc_springboot.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final BooleanPath optional = createBoolean("optional");

    public final StringPath title = createString("title");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QTerms(String variable) {
        super(Terms.class, forVariable(variable));
    }

    public QTerms(Path<? extends Terms> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTerms(PathMetadata metadata) {
        super(Terms.class, metadata);
    }

}

