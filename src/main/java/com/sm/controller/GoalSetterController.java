package com.sm.controller;

import com.sm.model.Goal;
import com.sm.service.GoalSetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class GoalSetterController {

  private final GoalSetterService goalSetterService;

  @GetMapping
  public String goalSetterView(Model model, @ModelAttribute Goal goal) {
    model.addAttribute("goals", goalSetterService.findAllGoals());

    return "goal-setter";
  }

  @PostMapping
  public String setGoal(Goal goalToSave) {
    goalSetterService.saveGoal(goalToSave);

    return "redirect:/";
  }

}
