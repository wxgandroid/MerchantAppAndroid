package com.pujitech.commonhttplibrary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangXuguang on 2017/9/26.
 */

public interface RxLifeRecycle {

    List<CommonObserver> mObservers = new ArrayList<>();

    void setRegisterObject(CommonObserver observer);

}
