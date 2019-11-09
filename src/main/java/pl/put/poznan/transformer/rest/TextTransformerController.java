package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;


@Controller
@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms, 
                              Model model) {
        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // do the transformation, you should run your logic here, below just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        
		model.addAttribute("transformerObject", transformer);//transformer will go to variable transformerObject in main.jsp
        return "main";
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@ModelAttribute("transformerObject")TextTransformer transformer,
                      Model model) {
        // log the parameters
        for (String a : transformer.getTransforms()) 
        	logger.debug(a);
        logger.debug(transformer.getTextToChange());
        // do the transformation, you should run your logic here, below just a silly example
        TextTransformer transformer2 = new TextTransformer();
        model.addAttribute("transformerObject", transformer2);//transformer2 will go to variable transformerObject in main.jsp
        return "redirect:/hello";
    }



}


