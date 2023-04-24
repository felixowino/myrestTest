package com.example.demo.ServicePackg;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DAOPackage.DaoClass;
import com.example.demo.DAOPackage.UsersDao;
import com.example.demo.RepoPackg.JpaRepoClass;
import com.example.demo.RepoPackg.Urepo;
import com.example.demo.entitypackage.LyrcsEntity;
import com.example.demo.entitypackage.MembersEntity;



@Service
public class ServiceClass implements servicePackage {
	@Autowired
	private JpaRepoClass jpa;
	@Autowired
	private Urepo repo;
//	@Autowired
//	private BCryptPasswordEncoder brypt;

	@Override
	public void saveKilifiTworecord(DaoClass dao) {
		dao.getPasspotphoto();
		dao.getSongArtist();
		dao.getSongDesc();
		dao.getSongDialct();
		dao.getSongLyrics();
		dao.getSongName();
		dao.getYoutubelnk();
		System.out.println("my dao is " + dao);
		LyrcsEntity lyrc = new LyrcsEntity();
		lyrc.setMyArtist(dao.getSongArtist());
		lyrc.setMypasspotphoto(dao.getPasspotphoto());
		lyrc.setMyLyrics(dao.getSongLyrics());
		lyrc.setMysongDesc(dao.getSongDesc());
		lyrc.setMysongName(dao.getSongName());
		lyrc.setMysongDialct(dao.getSongDialct());
		lyrc.setTheYoutubelnk(dao.getYoutubelnk());
		System.out.println("my entity is " + lyrc);
		LyrcsEntity lyrcsEntity = jpa.save(lyrc);
		System.out.println(lyrcsEntity);

	}

	//@SuppressWarnings("unchecked")
	@Override
	public List< DaoClass> getalldata() {
		List<LyrcsEntity> findAll= jpa.findAll();
		LyrcsEntity entity = new LyrcsEntity();
		ModelMapper modelmap =  new ModelMapper();
		//ModelMapper modelmap2 = modelmap;
		modelmap.typeMap(LyrcsEntity.class , DaoClass.class).addMappings(mapper -> {
			
			mapper.map(source -> source.getMyArtist(), DaoClass::setSongArtist);
			mapper.map(source -> source.getMyLyrics(), DaoClass::setSongLyrics);
			mapper.map(source-> source.getMypasspotphoto(), DaoClass::setPasspotphoto);
			mapper.map(source-> source.getMysongDesc(), DaoClass::setSongDesc);
			mapper.map(source->source.getMysongName(), DaoClass::setSongName);
			mapper.map(source->source.getMysongDialct(), DaoClass::setSongDialct);
			mapper.map(source->source.getTheYoutubelnk(), DaoClass::setYoutubelnk);
	
		});
		/*
		 * 
		 * 
		 * List<PersonDAO> daoList = Arrays.asList(new PersonDAO(1L, "John", "john@example.com"), new PersonDAO(2L, "Jane", "jane@example.com"));
List<Person> entityList = daoList.stream()
    .map(personDAO -> modelMapper.map(personDAO, Person.class))
    .collect(Collectors.toList());

System.out.println(entityList); // prints a list of Person objects

		 * 
		 * 
		 * */
		
		
		List<DaoClass> collect = findAll.stream().map(entityclass-> modelmap.map(entityclass, DaoClass.class)).collect(Collectors.toList());
		
		
		System.out.println("-----"+ collect);
		
		
		
		System.out.println(modelmap);

		 //List<DaoClass> mydao = new ArrayList<DaoClass>();

		 
		// mydao= (List<DaoClass>) modelmap.map(findAll, DaoClass.class);

		
		
		
		System.out.println("......." +collect.size());
 
// //DaoClass mynewdao = new DaoClass();
// 
// 
// 
// 
//                  for(LyrcsEntity myrc : findAll) {
//                	  mynewdao.setSongArtist(myrc.getMyArtist());
//                	  mynewdao.setPasspotphoto(myrc.getMypasspotphoto());
//                	  mynewdao.setSongDesc(myrc.getMysongDesc());
//                	  mynewdao.setSongDialct(myrc.getMysongDialct());
//                	  mynewdao.setSongLyrics(myrc.getMyLyrics());
//                	  mynewdao.setSongName(myrc.getMysongName());
//                	  mynewdao.setYoutubelnk(myrc.getTheYoutubelnk());
//                	  
//                  }
//                  mydao.add(mynewdao);
//
//
//		
//
//		
//		System.out.println("and this is it  "+mydao);
//		System.out.println(mydao.size());
		return collect;
	}

	@Override
	public List<DaoClass> getformdata(String nameinput  ) {
//	DaoClass dao = new DaoClass();
//	LyrcsEntity entity = new LyrcsEntity();
		
		DaoClass dao = new DaoClass();
		dao.getSongName();
		dao.getSongArtist();
		LyrcsEntity entity = new LyrcsEntity();
		entity.setMyArtist(dao.getSongArtist());
		entity.setMysongName(dao.getSongName());
		
		List<LyrcsEntity> myentity =jpa.findByMysongNameOrMyArtist(nameinput, nameinput);
		
		ModelMapper modelmap =  new ModelMapper();
		modelmap.typeMap(LyrcsEntity.class , DaoClass.class).addMappings(mapper -> {
			mapper.map(source->source.getMysongName(), DaoClass::setSongName);
			mapper.map(source -> source.getMyArtist(), DaoClass::setSongArtist);
			mapper.map(source -> source.getMyLyrics(), DaoClass::setSongLyrics);
			mapper.map(source-> source.getMypasspotphoto(), DaoClass::setPasspotphoto);
			mapper.map(source-> source.getMysongDesc(), DaoClass::setSongDesc);
			
			mapper.map(source->source.getMysongDialct(), DaoClass::setSongDialct);
			mapper.map(source->source.getTheYoutubelnk(), DaoClass::setYoutubelnk);
	
		});
		
List<DaoClass> collect1 = myentity.stream().map(entityclass-> modelmap.map(entityclass, DaoClass.class)).collect(Collectors.toList());
		
		
		System.out.println("-----"+ collect1);
		
		
		return collect1;
	}

	@Override
	public void deletemyrecord(int myid) {
		
		
		 jpa.deleteById(myid);
	System.out.println("the data deleted successfully");
		
	}

	@Override
	public DaoClass saveupdate(int id, String myartist, String mylyrics, String sname, String mydialect,
			String describe, String youtube, String result) {
	
		Optional<LyrcsEntity> findById = jpa.findById(id);
		if(findById.isPresent())
		{
			LyrcsEntity myupdaterecord = findById.get();
			
			
			//Person existingPerson = optionalPerson.get();
			myupdaterecord.setMyArtist(myartist);
			myupdaterecord.setMyLyrics(mylyrics);
			myupdaterecord.setMypasspotphoto(result);
			myupdaterecord.setMysongDesc(describe);
			myupdaterecord.setMysongDialct(mydialect);
			myupdaterecord.setTheYoutubelnk(youtube);
			myupdaterecord.setMysongName(sname);
			
			LyrcsEntity updateobject = jpa.save(myupdaterecord);
			
			ModelMapper modelmap1 =  new ModelMapper();
			modelmap1.typeMap(LyrcsEntity.class, DaoClass.class).addMappings(mapper->
			{
				mapper.map(source->source.getMysongName(), DaoClass::setSongName);
				mapper.map(source -> source.getMyArtist(), DaoClass::setSongArtist);
				mapper.map(source -> source.getMyLyrics(), DaoClass::setSongLyrics);
				mapper.map(source-> source.getMypasspotphoto(), DaoClass::setPasspotphoto);
				mapper.map(source-> source.getMysongDesc(), DaoClass::setSongDesc);
				
				mapper.map(source->source.getMysongDialct(), DaoClass::setSongDialct);
				mapper.map(source->source.getTheYoutubelnk(), DaoClass::setYoutubelnk);
			
			
			});
			
			if(updateobject  != null)	{
				 DaoClass daoClass = modelmap1.map(updateobject, DaoClass.class);
			return daoClass;
			}
		
		}
	
		
	return null;
}

	
	
	
	
	@Override
	public void savemyuser(UsersDao udao) {
		System.out.println("nnnnnnnnn "+ udao.getStringseven());
		System.out.println(">>>>>>>>>>"+udao.getStringfour());
		BCryptPasswordEncoder brypt=new BCryptPasswordEncoder();
		System.out.println("password is "+udao.getStringseven());
		String encode = brypt.encode(udao.getStringseven());
		udao.setStringseven(encode);
		System.out.println("the encoded pass "+ udao.getStringseven() );
		System.out.println(">>>>>>>>>>"+udao.getStringfour());
		udao.setStringfiften(1);
		System.out.println("second name===== "+udao.getStringfour());
		// TODO Auto-generated method stub
		ModelMapper mapp = new ModelMapper();
		mapp.typeMap(UsersDao.class, MembersEntity.class).addMappings(mapper ->
				{
			mapper.map(my->my.getStringone(), MembersEntity::setId);
			mapper.map(my->my.getStringtwo(), MembersEntity::setFirstName);
			mapper.map(my->my.getStringfour(), MembersEntity::setSecondName);
			mapper.map(my->my.getStringseven(), MembersEntity::setPassword);
			mapper.map(my->my.getStringten(), MembersEntity::setEmail);
			mapper.map(my->my.getStringtwelve(), MembersEntity::setAuthorities);
			mapper.map(my->my.getStringfiften(), MembersEntity::setEnabled);
			mapper.map(my->my.getStringthree(), MembersEntity::setUsername);
				}
				
				
				);
		MembersEntity mymbers = mapp.map(udao, MembersEntity.class);
		System.out.println("the id is>>>>>>> "+ mymbers.getId());
		System.out.println("....................."+mymbers);
		repo.save(mymbers);
		
		System.out.println("the id is>>>>>>> "+ mymbers.getId());

		System.out.println("save sucessfully");
		
	}
	
}



/*
 * 
 * 
 * Explicit mapping for a list object in ModelMapper involves specifying how the elements in the source list should be mapped to elements in the target list. Here's an example of how to do this:

Create a new ModelMapper instance:
java
Copy code
ModelMapper modelMapper = new ModelMapper();
Create a source object that contains a list of elements:
java
Copy code
class SourceObject {
    private List<String> names;

    // getters and setters
}
Create a target object that contains a list of elements:
java
Copy code
class TargetObject {
    private List<String> titles;

    // getters and setters
}
Define the mapping between the source and target objects using an explicit mapping for the names list:
java
Copy code
modelMapper.createTypeMap(SourceObject.class, TargetObject.class)
    .addMappings(new PropertyMap<SourceObject, TargetObject>() {
        @Override
        protected void configure() {
            map().setTitles(source.getNames());
        }
    });
This code maps the names list in the SourceObject to the titles list in the TargetObject.

Now you can use the modelMapper instance to map a SourceObject object to a TargetObject object:
java
Copy code
SourceObject sourceObject = new SourceObject();
sourceObject.setNames(Arrays.asList("Mr.", "Mrs.", "Miss", "Dr."));

TargetObject targetObject = modelMapper.map(sourceObject, TargetObject.class);
System.out.println(targetObject.getTitles()); // prints ["Mr.", "Mrs.", "Miss", "Dr."]
This code creates a SourceObject object with a list of names, and maps it to a TargetObject object. The resulting TargetObject object has a list of titles that is the same as the list of names in the SourceObject.
 * 
 * 
 * 
 * 
 * 
 * ......................................................................
 * 
In ModelMapper, you can map a List of objects explicitly by defining a TypeMap that maps the elements of the list. Here's an example of how to do this for mapping a List of DAO objects to Entity objects:

Create a DAO object that represents a single record in the database:
java
Copy code
class PersonDAO {
    private Long id;
    private String name;
    private String email;

    // getters and setters
}
Create an Entity object that represents a domain object:
java
Copy code
class Person {
    private Long id;
    private String name;
    private String email;

    // getters and setters
}
Define a TypeMap that maps a PersonDAO object to a Person object:
java
Copy code
TypeMap<PersonDAO, Person> typeMap = modelMapper.createTypeMap(PersonDAO.class, Person.class);
typeMap.addMapping(PersonDAO::getId, Person::setId);
typeMap.addMapping(PersonDAO::getName, Person::setName);
typeMap.addMapping(PersonDAO::getEmail, Person::setEmail);
In this code, we create a TypeMap that maps from PersonDAO to Person, and add mappings for each field in the objects.

Now you can use the typeMap to map a List of PersonDAO objects to a List of Person objects:
java
Copy code
List<PersonDAO> daoList = Arrays.asList(new PersonDAO(1L, "John", "john@example.com"), new PersonDAO(2L, "Jane", "jane@example.com"));
List<Person> entityList = daoList.stream()
    .map(personDAO -> modelMapper.map(personDAO, Person.class))
    .collect(Collectors.toList());

System.out.println(entityList); // prints a list of Person objects
This code creates a List of PersonDAO objects, and maps each PersonDAO object to a Person object using the typeMap. The resulting List of Person objects contains the same data as the original List of PersonDAO objects, but in the Person object format.




 * */







