package com.sm.service;

import com.sm.model.Goal;

import java.util.List;

public interface GoalSetterService {

  List<Goal> findAllGoals();

  void saveGoal(Goal goal);

}
