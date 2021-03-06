package com.dmj.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dmj.entity.Book;
import com.dmj.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	private String list(Model model) {
		List<Book> list = bookService.getList(0, 1000);
		model.addAttribute("list", list);
		return "list";// WEB-INF/jsp/"list".jsp
	}

	@RequestMapping(value = "/detail/{bookId}", method = RequestMethod.GET)
	private String detail(@PathVariable("bookId") Long bookId, Model model) {
		Book book = bookService.getById(bookId);
		model.addAttribute("book", book);
		return "detail";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	// @ResponseBody
	private String add(Book book, Model model) {
		Book hasBook = bookService.getById(book.getBookId());
		int i = -2;
		if (hasBook == null) {
			i = bookService.addBook(book);
		}
		// return i > 0 ? "success" : "error";

		if (i > 0) {
			List<Book> list = bookService.getList(0, 1000);
			model.addAttribute("list", list);
			return "list";// WEB-INF/jsp/"list".jsp
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "/update/{bookId}", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	private String update(@PathVariable("bookId") Long bookId, Model model) {
		Book hasBook = bookService.getById(bookId);
		int i = -2;
		if (hasBook == null) {
			i = bookService.updateBook(hasBook);
		}
		// return i > 0 ? "success" : "error";

		if (i > 0) {
			List<Book> list = bookService.getList(0, 1000);
			model.addAttribute("list", list);
			return "list";// WEB-INF/jsp/"list".jsp
		} else {
			return "error";
		}
	}
	
	@RequestMapping("update")
	public ModelAndView updateCategory(Book book){
		bookService.updateBook(book);
		ModelAndView mav = new ModelAndView("redirect:/book/list");
		return mav;
	}	

	
	@RequestMapping("edit")
	public ModelAndView editCategory(Book book){
		Book b= bookService.getById(book.getBookId());
		ModelAndView mav = new ModelAndView("edit");
		mav.addObject("b", b);
		return mav;
	}	

	@RequestMapping(value = "/del/{bookId}", method = RequestMethod.GET)
	@ResponseBody
	private String deleteBookById(@PathVariable("bookId") Long id) {
		int i = bookService.deleteBookById(id);
		return i > 0 ? "success" : "error";
	}
}
