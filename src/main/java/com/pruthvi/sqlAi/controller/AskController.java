package com.pruthvi.sqlAi.controller;

import com.pruthvi.sqlAi.model.QueryResult;
import com.pruthvi.sqlAi.service.SqlQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AskController {
    private static final Logger logger = LoggerFactory.getLogger(AskController.class);
    private final SqlQueryService sqlQueryService;
    public AskController(SqlQueryService sqlQueryService) {
        this.sqlQueryService = sqlQueryService;
    }

    @GetMapping("/")
    public String index() {
        logger.debug("Accessing index page");
        return "index";
    }

    @PostMapping("/ask")
    public String ask(@RequestParam String question, RedirectAttributes redirectAttributes) {
        logger.info("Received question: {}", question);
        try {
            QueryResult result = sqlQueryService.processQuestion(question);
            redirectAttributes.addFlashAttribute("question", question);
            redirectAttributes.addFlashAttribute("sql", result.getSql());
            redirectAttributes.addFlashAttribute("executionTime", result.getExecutionTimeMs());

            if (result.hasResults()) {
                redirectAttributes.addFlashAttribute("headers", result.getHeaders());
                redirectAttributes.addFlashAttribute("rows", result.getRows());
            } else {
                redirectAttributes.addFlashAttribute("error", "There are no results for this request");
            }
        } catch (Exception e) {
            logger.error("Error processing question: {}", e.getMessage(), e);
            redirectAttributes.addFlashAttribute("error", "Error processing your question: " + e.getMessage());
        }

        return "redirect:/";
    }

    @GetMapping("/ask")
    public String askGet() {
        // Handle GET requests to /ask by redirecting to home
        return "redirect:/";
    }

}
