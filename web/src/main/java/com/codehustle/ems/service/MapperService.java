package com.codehustle.ems.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MapperService {

    @Autowired
    private ModelMapper modelMapper;

    public <T> T map(Object source, Class<T> target){
        return modelMapper.map(source,target);
    }

    public <S,T> List<T> map(List<S> source,Class<T> target){
        return source
                .stream()
                .map(element -> modelMapper.map(element,target))
                .collect(Collectors.toList());
    }

}
