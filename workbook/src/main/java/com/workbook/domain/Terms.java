package com.workbook.domain;

import com.workbook.domain.common.BaseEntity;
import com.workbook.domain.enums.Optional;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long terms_id;

    private String title;

    private String body;

    @Enumerated(EnumType.STRING)
    private Optional optional;

}
