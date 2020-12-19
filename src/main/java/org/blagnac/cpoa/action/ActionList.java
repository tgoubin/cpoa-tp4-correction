package org.blagnac.cpoa.action;

public interface ActionList<E> {

	public String title();

	public boolean addAction(Action<E> actionContext);

	public boolean removeAction(Action<E> actionContext);

	public int listSize();

	public Action<E> getAction(int index);
}
