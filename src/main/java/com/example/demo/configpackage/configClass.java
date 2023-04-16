package com.example.demo.configpackage;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class configClass {
	@Bean
	public  ModelMapper mymapper(){
		
		
		
		
		/*
		 * import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public class MyClass {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class MyDTO {
    private int squaredValue;

    public int getSquaredValue() {
        return squaredValue;
    }

    public void setSquaredValue(int squaredValue) {
        this.squaredValue = squaredValue;
    }
}

List<MyClass> sourceList = List.of(new MyClass(1), new MyClass(2), new MyClass(3));

ModelMapper modelMapper = new ModelMapper();

// Create a mapping expression that maps the value of MyClass to the squaredValue of MyDTO
modelMapper.typeMap(MyClass.class, MyDTO.class)
    .addMappings(mapper -> mapper.map(src -> src.getValue() * src.getValue(), MyDTO::setSquaredValue));

// Use the map method of ModelMapper to create a new list of MyDTO objects
List<MyDTO> destinationList = sourceList.stream()
    .map(myClass -> modelMapper.map(myClass, MyDTO.class))
    .collect(Collectors.toList());

System.out.println(destinationList);  // Output: [MyDTO{squaredValue=1}, MyDTO{squaredValue=4}, MyDTO{squaredValue=9}]

		 * */
		return new ModelMapper();
		
	}
	
	
}
