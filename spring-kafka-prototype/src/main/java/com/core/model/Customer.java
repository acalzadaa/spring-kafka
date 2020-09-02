package com.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	@NonNull
	String name;
	@NonNull
	String lastName;
	@NonNull
	String firstName;

}
