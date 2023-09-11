package com.sm.service.impl;

import com.sm.model.Goal;
import com.sm.repository.GoalRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class GoalSetterServiceImplTest {

  @Mock
  private GoalRepository goalRepository;

  @InjectMocks
  private GoalSetterServiceImpl goalSetterService;

  @Test
  void findAllGoals() {
    List<Goal> expectedGoals = List.of(Goal.withTitle("goal1"));

    given(goalRepository.findAll()).willReturn(expectedGoals);

    List<Goal> goals = goalSetterService.findAllGoals();

    assertEquals(expectedGoals.size(), goals.size());
    assertEquals(expectedGoals.get(0).getTitle(), goals.get(0).getTitle());
  }

}