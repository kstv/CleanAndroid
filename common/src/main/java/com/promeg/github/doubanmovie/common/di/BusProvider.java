package com.promeg.github.doubanmovie.common.di;


import com.promeg.github.doubanmovie.common.utils.visibility.PackagePrivate;

import de.greenrobot.event.EventBus;

/**
 * Created by guyacong on 2015/4/19.
 */
@PackagePrivate
class BusProvider {

    public static EventBus getBus() {
        return BusProviderrHolder.instance;
    }

    private static class BusProviderrHolder {
        private static final EventBus instance = EventBus.builder()
                .logNoSubscriberMessages(false)
                .sendNoSubscriberEvent(false)
                .eventInheritance(true)
                .throwSubscriberException(true)
                .build();
    }

    private BusProvider() {
        // No instances.
    }
}
