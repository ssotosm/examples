package observerone;

public interface ISubject {
	
	public void registrer(IObserver observer);

	public void remove(IObserver observer);

	public void notifyObservers();
}
