package com.sfac.AGlobalVoiceForAutism.callBack;

import com.sfac.AGlobalVoiceForAutism.model.Questions2;

public interface QuizCallBack {
  void onFirstOptionClicked(Questions2 task);
  void onSecondOptionClicked(Questions2 task);
  void onThirdOptionClicked(Questions2 task);
  void onFourthOptionClicked(Questions2 task);
}
