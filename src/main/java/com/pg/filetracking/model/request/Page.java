package com.pg.filetracking.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Page<T> {

    public Page(List<T> data) {
        this.data = data;
    }

    private List<T> data;
    private Long recordsFiltered;
    private Long recordsTotal;
    private int draw;

}