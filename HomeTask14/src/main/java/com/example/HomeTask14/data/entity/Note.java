package com.example.HomeTask14.data.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Note {

	private UUID id;
	private String title;
	private String content;
}
