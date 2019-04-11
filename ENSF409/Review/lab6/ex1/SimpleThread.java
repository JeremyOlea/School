
public class SimpleThread implements Runnable{

	Resource resource;
	
	public void run() {
		for(int i = 0; i<10; i++){
			try {
			System.out.println(resource.increment());
			
			Thread.sleep(1);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	SimpleThread(Resource r){
		this.resource = r;
	}

	public static void main(String args[]) {
		Resource resource = new Resource();
		Runnable r = new SimpleThread(resource);
		Thread t = new Thread(r);
		Thread s = new Thread(r);
		
		t.start();
		s.start();
	}

}
