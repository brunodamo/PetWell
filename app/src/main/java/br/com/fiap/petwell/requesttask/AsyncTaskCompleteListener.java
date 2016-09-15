package br.com.fiap.petwell.requesttask;

public interface AsyncTaskCompleteListener<T> {
    public void onTaskComplete(T result);

}
