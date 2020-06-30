package com.sfac.AGlobalVoiceForAutism.repository;

import com.sfac.AGlobalVoiceForAutism.R;
import com.sfac.AGlobalVoiceForAutism.model.ActivitiesItem;

import java.util.ArrayList;
import java.util.List;

public class VideoRepository {

    private static VideoRepository instance;
    private List<ActivitiesItem> aI = new ArrayList<>();

    public static VideoRepository getInstance() {
        if(instance == null){
            instance = new VideoRepository();
        }
        return instance;
    }

    private VideoRepository() {
        fillvideoPrincipalList();
    }
    public ActivitiesItem reproduceVideo(String id, String name) {
        for (ActivitiesItem video : aI) {
            if (video.getId().equals(id) && video.getName().equals(name)) {
                return video;
            }
        }
        return null;
    }



    private void fillvideoPrincipalList(){
        aI.add(new ActivitiesItem(1,"KcBmrnBmdzM","Khokha",".jpg",
                "NOT", R.drawable.elmo_1));
    }
}
