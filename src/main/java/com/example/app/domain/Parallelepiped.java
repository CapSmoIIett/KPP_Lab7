package com.example.app.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Parallelepiped {
    @Getter
    double height;
    @Getter
    double width;
    @Getter
    double depth;
}
