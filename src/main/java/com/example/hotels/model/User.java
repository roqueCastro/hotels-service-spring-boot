package com.example.hotels.model;

import java.io.Serializable;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Document(collection = "users")
@JsonPropertyOrder({"userId", "name"})
@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = -7788619177798333712L;
	@Id
	@NotNull 
	private String userId;
	@NotNull
	private String name;

}
