package com.example.projetg4.controllers;





import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.projetg4.models.Figure;
import com.example.projetg4.repositories.FigureRepo;


@CrossOrigin("*")
@RestController
public class CategoryController {

	
	
	@Autowired
	private FigureRepo rep;
	
	
	@GetMapping("/getfiguresbycategory/{category}")
    public List<Figure> getByCategory(@PathVariable String category ){
		
        List<Figure> figures = this.rep.findByCategory(category);
        return figures;
        
    }
	
	

	
	
	
	
	
	
}
