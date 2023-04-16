package com.example.demo.ControllersPackage;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.DAOPackage.DaoClass;
import com.example.demo.ServicePackg.servicePackage;
import com.example.demo.modelPackage.RecordModelClass;

@RestController
public class defaultController {
	@Autowired
	private servicePackage service;

	@GetMapping(value = "/")
	public ResponseEntity<List<RecordModelClass>> myresponse() {

		List<DaoClass> mydao = service.getalldata();
		List<RecordModelClass> mydao1 = new ArrayList<RecordModelClass>();
		System.out.println(mydao.size());
		System.out.println("hhhhhh " + mydao);

		ModelMapper mapper = new ModelMapper();
		TypeMap<DaoClass, RecordModelClass> mytypemap = mapper.createTypeMap(DaoClass.class, RecordModelClass.class);
		mytypemap.addMapping(DaoClass::getSongArtist, RecordModelClass::setArtist);
		mytypemap.addMapping(DaoClass::getSongDesc, RecordModelClass::setDesc);
		mytypemap.addMapping(DaoClass::getSongDialct, RecordModelClass::setDialct);
		mytypemap.addMapping(DaoClass::getPasspotphoto, RecordModelClass::setPhoto);
		mytypemap.addMapping(DaoClass::getSongLyrics, RecordModelClass::setLyrics);
		mytypemap.addMapping(DaoClass::getSongName, RecordModelClass::setName);
		mytypemap.addMapping(DaoClass::getYoutubelnk, RecordModelClass::setYoutube);

		List<RecordModelClass> collect = mydao.stream().map(record -> mapper.map(record, RecordModelClass.class))
				.collect(Collectors.toList());
		// mod.addAttribute("mydataholder", collect);

		System.out.println("the concept" + collect);

		if (collect != null) {

			return ResponseEntity.status(HttpStatus.FOUND).body(collect);

		} else {
			return ResponseEntity.notFound().build();
		}

	}

//	public String HomepageMombasaOne(Model mod) {
//		List<DaoClass> mydao = service.getalldata();
//		List<RecordModelClass> mydao1 = new ArrayList<RecordModelClass>();
//		System.out.println(mydao.size());
//		System.out.println("hhhhhh " + mydao);
//
//		ModelMapper mapper = new ModelMapper();
//		TypeMap<DaoClass, RecordModelClass> mytypemap = mapper.createTypeMap(DaoClass.class, RecordModelClass.class);
//		mytypemap.addMapping(DaoClass::getSongArtist, RecordModelClass::setArtist);
//		mytypemap.addMapping(DaoClass::getSongDesc, RecordModelClass::setDesc);
//		mytypemap.addMapping(DaoClass::getSongDialct, RecordModelClass::setDialct);
//		mytypemap.addMapping(DaoClass::getPasspotphoto, RecordModelClass::setPhoto);
//		mytypemap.addMapping(DaoClass::getSongLyrics, RecordModelClass::setLyrics);
//		mytypemap.addMapping(DaoClass::getSongName, RecordModelClass::setName);
//		mytypemap.addMapping(DaoClass::getYoutubelnk, RecordModelClass::setYoutube);
//		
//
//		// DaoClass dto = new DaoClass();
////		RecordModelClass record = new RecordModelClass();
////		for( DaoClass  dto: mydao ) {
////		record.setArtist(dto.getSongArtist());
////		record.setDesc(dto.getSongDesc());
////		record.setDialct(dto.getSongDialct());
////		record.setLyrics(dto.getSongLyrics());
////		record.setPhoto(dto.getPasspotphoto());
////		record.setName(dto.getSongName());
////		record.setYoutube(dto.getYoutubelnk());
////		}
//		// mydao1.add(record);
//		List<RecordModelClass> collect = mydao.stream().map(record -> mapper.map(record, RecordModelClass.class))
//				.collect(Collectors.toList());
//		mod.addAttribute("mydataholder", collect);
//
//		System.out.println("the concept" + collect);
//		return "Nyali";
//	}

	@PostMapping(value = "/ddRecord")
	public ResponseEntity<Object> myrequest(@RequestParam("Artist") String myrtist,
			@RequestParam("Lyrics") String lyrics, @RequestParam("Desc") String Description,
			@RequestParam("Dialct") String dialect, @RequestParam("Name") String Name,
			@RequestParam("Youtube") String youtube, @RequestParam("photo") MultipartFile malti) {

		System.out.println("my data is " + myrtist + lyrics);

		////////////////////////////////////

		RecordModelClass record = new RecordModelClass();

		byte[] bytes = null;
		try {
			bytes = malti.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = Base64.getEncoder().encodeToString(bytes);

		record.setArtist(myrtist);
		record.setDesc(Description);
		record.setDialct(dialect);
		record.setLyrics(lyrics);
		record.setName(Name);
		record.setPhoto(result);
		record.setYoutube(youtube);

		System.out.println(record);

		DaoClass dao = new DaoClass();
		dao.setPasspotphoto(record.getPhoto());
		dao.setSongArtist(record.getArtist());
		dao.setSongDesc(record.getDesc());
		dao.setSongDialct(record.getDialct());
		dao.setSongName(record.getName());
		dao.setYoutubelnk(record.getYoutube());
		dao.setSongLyrics(record.getLyrics());
		System.out.println("my record " + dao.getSongDialct());
		service.saveKilifiTworecord(dao);

		///////////////////////////////////////////

//			 @PostMapping("/example")
//			    public ResponseEntity<Void> handlePostRequest(@RequestParam("param1") String param1, 
//			                                                   @RequestParam("param2") int param2) {
//			        // Logic to handle the POST request with query parameters
//			        // You can access the query parameters using the @RequestParam annotation
//			        
//			        // Perform some operation based on the query parameters
//			        
//			        // Redirect to a different URL
//			        HttpHeaders responseHeaders = new HttpHeaders();
//			        responseHeaders.setLocation(URI.create("http://example.com/redirected"));
//			        return ResponseEntity.status(HttpStatus.SEE_OTHER).headers(responseHeaders).build();
//			    }
		//////////////////////////////////////////

		HttpHeaders myHeaderesponse = new HttpHeaders();
		myHeaderesponse.setLocation(URI.create("http://localhost:8080"));
		return ResponseEntity.status(HttpStatus.SEE_OTHER).headers(myHeaderesponse).build();

	}

	public String KilifiTwo(@RequestParam("Artist") String myrtist, @RequestParam("Lyrics") String lyrics,
			@RequestParam("Desc") String Description, @RequestParam("Dialct") String dialect,
			@RequestParam("Name") String Name, @RequestParam("Youtube") String youtube,
			@RequestParam("photo") MultipartFile malti) {

		RecordModelClass record = new RecordModelClass();

		byte[] bytes = null;
		try {
			bytes = malti.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = Base64.getEncoder().encodeToString(bytes);

		record.setArtist(myrtist);
		record.setDesc(Description);
		record.setDialct(dialect);
		record.setLyrics(lyrics);
		record.setName(Name);
		record.setPhoto(result);
		record.setYoutube(youtube);

		System.out.println(record);

		DaoClass dao = new DaoClass();
		dao.setPasspotphoto(record.getPhoto());
		dao.setSongArtist(record.getArtist());
		dao.setSongDesc(record.getDesc());
		dao.setSongDialct(record.getDialct());
		dao.setSongName(record.getName());
		dao.setYoutubelnk(record.getYoutube());
		dao.setSongLyrics(record.getLyrics());
		System.out.println("my record " + dao.getSongDialct());
		service.saveKilifiTworecord(dao);

		return "KilifiSouth";
	}

	@PutMapping(value = "/updrecord")
	public RequestEntity<RecordModelClass> LamuThree(@RequestParam("Id") int id,
			@RequestParam("updateartist") String myartist, @RequestParam("lyrs") String mylyrics,
			@RequestParam("songname") String Sname, @RequestParam("dialect") String mydialect,
			@RequestParam("description") String describe, @RequestParam("Youtube") String youtube,
			@RequestParam("image") MultipartFile photo) {
		
		byte[] bytes = null;
		try {
			bytes = photo.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = Base64.getEncoder().encodeToString(bytes);
		DaoClass mydaocls = service.saveupdate(id, myartist, mylyrics, Sname, mydialect, describe, youtube, result);
System.out.println("the code was executede  successfully......"+mydaocls);

		return null;
	}

	@GetMapping(value = "/search")

	////////////////////////////////////////////////

	public ResponseEntity<List<RecordModelClass>> searchItem(@RequestParam("name") String nameinput) {

		List<DaoClass> myd = service.getformdata(nameinput);
		ModelMapper modelmap = new ModelMapper();
		modelmap.typeMap(DaoClass.class, RecordModelClass.class).addMappings(mapper -> {

			mapper.map(source -> source.getSongArtist(), RecordModelClass::setArtist);
			mapper.map(source -> source.getSongDesc(), RecordModelClass::setDesc);
			mapper.map(source -> source.getSongDialct(), RecordModelClass::setDialct);
			mapper.map(source -> source.getSongLyrics(), RecordModelClass::setLyrics);
			mapper.map(source -> source.getPasspotphoto(), RecordModelClass::setPhoto);
			mapper.map(source -> source.getYoutubelnk(), RecordModelClass::setYoutube);
			mapper.map(source -> source.getSongName(), RecordModelClass::setName);

		});
		System.out.println("inside the c+ontroller");
		List<RecordModelClass> collect1 = myd.stream().map(daoclass -> modelmap.map(daoclass, RecordModelClass.class))
				.collect(Collectors.toList());

		System.out.println("the basic principle");
		System.out.println("my collect is " + collect1);

		if (collect1 != null) {

			return ResponseEntity.status(HttpStatus.FOUND).body(collect1);

		} else {
			return ResponseEntity.notFound().build();
		}

	}

	/////////////////////////////////////////////////

	public String searchController(@RequestParam("name") String nameinput, Model model) {
		// System.out.println(formInput);
		List<DaoClass> myd = service.getformdata(nameinput);
		ModelMapper modelmap = new ModelMapper();
		modelmap.typeMap(DaoClass.class, RecordModelClass.class).addMappings(mapper -> {

			mapper.map(source -> source.getSongArtist(), RecordModelClass::setArtist);
			mapper.map(source -> source.getSongDesc(), RecordModelClass::setDesc);
			mapper.map(source -> source.getSongDialct(), RecordModelClass::setDialct);
			mapper.map(source -> source.getSongLyrics(), RecordModelClass::setLyrics);
			mapper.map(source -> source.getPasspotphoto(), RecordModelClass::setPhoto);
			mapper.map(source -> source.getYoutubelnk(), RecordModelClass::setYoutube);
			mapper.map(source -> source.getSongName(), RecordModelClass::setName);

		});
		System.out.println("inside the controller");
		List<RecordModelClass> collect1 = myd.stream().map(daoclass -> modelmap.map(daoclass, RecordModelClass.class))
				.collect(Collectors.toList());

		System.out.println("the basic principle");
		System.out.println("my collect is " + collect1);
		model.addAttribute("collect", collect1);

		return "makongo";
	}

	@DeleteMapping(value = "/dltrecord")
	public ResponseEntity<Object> TanaRvr(@RequestParam("id") int myid) {
		System.out.println("the submitted id is " + myid);

		service.deletemyrecord(myid);

		HttpHeaders myHeaderesponse = new HttpHeaders();
		myHeaderesponse.setLocation(URI.create("http://localhost:8080"));
		return ResponseEntity.status(HttpStatus.SEE_OTHER).headers(myHeaderesponse).build();
	}

}
