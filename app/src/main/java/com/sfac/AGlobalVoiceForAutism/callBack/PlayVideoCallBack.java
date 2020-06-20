package com.sfac.AGlobalVoiceForAutism.callBack;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;

public interface PlayVideoCallBack {
  void onTaskVideoClicked(ActivitiesItem task);
  void onTaskQuizClicked(ActivitiesItem task);

}
