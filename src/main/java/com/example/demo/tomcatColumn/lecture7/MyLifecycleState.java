package com.example.demo.tomcatColumn.lecture7;

/**
 * he list of valid states for components that implement {@link ILifecycle}.
 * @author Alan Yin
 * @date 2020/8/17
 */

public enum MyLifecycleState {

    /**
     * 生命周期状态
     */
    NEW(false, null),
    INITIALIZING(false, ILifecycle.BEFORE_INIT_EVENT),
    INITIALIZED(false, ILifecycle.AFTER_INIT_EVENT),
    STARTING_PREP(false, ILifecycle.BEFORE_START_EVENT),
    STARTING(true, ILifecycle.START_EVENT),
    STARTED(true, ILifecycle.AFTER_START_EVENT),
    STOPPING_PREP(true, ILifecycle.BEFORE_STOP_EVENT),
    STOPPING(false, ILifecycle.STOP_EVENT),
    STOPPED(false, ILifecycle.AFTER_STOP_EVENT),
    DESTROYING(false, ILifecycle.BEFORE_DESTROY_EVENT),
    DESTROYED(false, ILifecycle.AFTER_DESTROY_EVENT),
    FAILED(false, null);

    private final boolean availabel;

    private final String lifecycleEvent;

    MyLifecycleState(boolean availabel, String lifecycleEvent) {
        this.availabel = availabel;
        this.lifecycleEvent = lifecycleEvent;
    }

    public boolean isAvailabel() {
        return availabel;
    }

    public String getLifecycleEvent() {
        return lifecycleEvent;
    }
}
