package com.sm.service.impl;

import com.sm.model.Goal;
import com.sm.repository.GoalRepository;
import com.sm.service.GoalSetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoalSetterServiceImpl implements GoalSetterService {

  private final GoalRepository goalRepository;

  @Override
  public List<Goal> findAllGoals() {
    return goalRepository.findAll();
  }

  @Override
  public void saveGoal(Goal goal) {
    goalRepository.save(goal);
  }

}
