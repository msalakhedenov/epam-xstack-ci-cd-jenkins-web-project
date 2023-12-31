package com.sm.service.impl;

import com.sm.model.Goal;
import com.sm.repository.GoalRepository;
import com.sm.service.GoalSetterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class GoalSetterServiceImplIntegrationTest {

  @Autowired
  private GoalSetterService goalSetterService;

  @Autowired
  private GoalRepository goalRepository;

  @Test
  void givenGoalSetterService_whenSaveAndRetrieveGoal_thenOk() {
    Goal goalToSave = new Goal();
    goalToSave.setTitle("Test");

    goalSetterService.saveGoal(goalToSave);

    List<Goal> goals = goalRepository.findAll();

    assertEquals(1, goals.size());
    assertEquals(goalToSave.getTitle(), goals.get(0).getTitle());
  }

}