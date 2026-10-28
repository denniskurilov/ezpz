package com.denniskurilov.ezpz.controller;

import com.denniskurilov.ezpz.entity.Employee;
import com.denniskurilov.ezpz.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// The id comes from the URL only, never from submitted form fields
	@InitBinder("employee")
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id", "createdAt");
	}

	@GetMapping("/")
	public String root() {
		return "redirect:/employees";
	}

	@GetMapping("/employees")
	public String list(@RequestParam(defaultValue = "1") int page, Model model,
					   RedirectAttributes redirectAttributes) {
		Page<Employee> employees = employeeService.findPage(page);

		// e.g. the last row of the last page was deleted - go to the new last page,
		// keeping the flash message ("Employee ... deleted") for one more redirect
		if (employees.isEmpty() && employees.getTotalPages() > 0) {
			if (model.containsAttribute("message")) {
				flash(redirectAttributes, (String) model.getAttribute("messageType"), (String) model.getAttribute("message"));
			}
			return redirectToList(employees.getTotalPages());
		}

		model.addAttribute("employees", employees.getContent());
		model.addAttribute("currentPage", employees.getNumber() + 1);
		model.addAttribute("totalPages", employees.getTotalPages());
		return "employees";
	}

	@GetMapping("/employees/new")
	public String createForm(@RequestParam(defaultValue = "1") int page, Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("page", page);
		return "employee";
	}

	@PostMapping("/employees")
	public String create(@Valid @ModelAttribute("employee") Employee employee, BindingResult result,
						 @RequestParam(defaultValue = "1") int page,
						 Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			model.addAttribute("page", page);
			return "employee";
		}

		Employee created = employeeService.create(employee);
		flash(redirectAttributes, "success", "Employee " + created.getFullName() + " added");
		return redirectToList(page);
	}

	@GetMapping("/employees/{id}/edit")
	public String editForm(@PathVariable Long id, @RequestParam(defaultValue = "1") int page,
						   Model model, RedirectAttributes redirectAttributes) {
		Optional<Employee> employee = employeeService.findById(id);
		if (employee.isEmpty()) {
			return notFound(page, redirectAttributes);
		}

		model.addAttribute("employee", employee.get());
		model.addAttribute("createdAt", employee.get().getCreatedAt());
		model.addAttribute("page", page);
		return "employee";
	}

	@PostMapping("/employees/{id}")
	public String update(@PathVariable Long id,
						 @Valid @ModelAttribute("employee") Employee employee, BindingResult result,
						 @RequestParam(defaultValue = "1") int page,
						 Model model, RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			// Re-render the form with the submitted values plus the read-only fields
			Optional<Employee> existing = employeeService.findById(id);
			if (existing.isEmpty()) {
				return notFound(page, redirectAttributes);
			}
			employee.setId(id);
			model.addAttribute("createdAt", existing.get().getCreatedAt());
			model.addAttribute("page", page);
			return "employee";
		}

		Optional<Employee> updated = employeeService.update(id, employee);
		if (updated.isEmpty()) {
			return notFound(page, redirectAttributes);
		}

		flash(redirectAttributes, "success", "Employee " + updated.get().getFullName() + " saved");
		return redirectToList(page);
	}

	@PostMapping("/employees/{id}/delete")
	public String delete(@PathVariable Long id, @RequestParam(defaultValue = "1") int page,
						 RedirectAttributes redirectAttributes) {
		Optional<Employee> deleted = employeeService.delete(id);
		if (deleted.isEmpty()) {
			return notFound(page, redirectAttributes);
		}

		flash(redirectAttributes, "success", "Employee " + deleted.get().getFullName() + " deleted");
		return redirectToList(page);
	}

	private String notFound(int page, RedirectAttributes redirectAttributes) {
		flash(redirectAttributes, "danger", "Employee not found");
		return redirectToList(page);
	}

	private static void flash(RedirectAttributes redirectAttributes, String type, String message) {
		redirectAttributes.addFlashAttribute("messageType", type);
		redirectAttributes.addFlashAttribute("message", message);
	}

	private static String redirectToList(int page) {
		return "redirect:/employees?page=" + page;
	}

}
