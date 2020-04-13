package sii.maroc.CQRS_training_v1.bases;


public class BaseEvent<T> {
    public final T id;
    public BaseEvent(T id) {
        this.id = id;
    }
}