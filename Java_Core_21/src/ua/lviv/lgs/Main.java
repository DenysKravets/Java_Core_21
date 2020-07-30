package ua.lviv.lgs;

import java.io.*;
import java.lang.reflect.*;
import java.time.*;
import java.util.*;

public class Main 
{

	public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException
	{
		//Part I
		//writes fields into the file with values set to true
		write(new Person("John", 1, 1));
		

		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\ua\\lviv\\lgs\\info.txt"));
		
		//shows that marked values were saved in a file
		System.out.println(objectInputStream.readObject());
		System.out.println(objectInputStream.readObject());
		
		objectInputStream.close();
		
		//Part II
		//
		System.out.println(convertTo(new Date(), LocalDate.class));
		System.out.println(convertTo(new Date(), LocalTime.class));
		System.out.println(convertTo(new Date(), LocalDateTime.class));
		
		
	}

	public static void write(Object object) throws FileNotFoundException, IOException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		
		ObjectOutputStream objectOutputStream = null;
		
		objectOutputStream = new ObjectOutputStream( new FileOutputStream("src\\ua\\lviv\\lgs\\info.txt"));
	
		
		Field[] fields = object.getClass().getFields();
		
		for(Field field: fields)
		{
			if(field.getAnnotation(MyAnnotation.class).value())
			{
				field.setAccessible(true);
				
				Object value = null;

				value = field.get(object);
				
				objectOutputStream.writeObject(value);
			}
			
		}

		objectOutputStream.close();
		}
	
	
	public static Object convertTo(Date date, Class class_) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException
	{
		
		if(class_.equals(LocalDate.class))
		{
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			return localDate;
			
		} else if(class_.equals(LocalTime.class))
		{
			LocalTime localTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
			return localTime;
			
		} else if(class_.equals(LocalDateTime.class))
		{
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalTime localTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
			
			LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
			return localDateTime;
		}

		return null;
	}
}
	


