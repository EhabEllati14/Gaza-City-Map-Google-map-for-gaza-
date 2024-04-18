package application;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	Stage stage1 = new Stage();
	Stage stage2 = new Stage();
    Stage stage3 = new Stage(); 

	public static double minlat = 31.59489;
	public static double minlong = 34.21869;
	public static double maxlat = 31.22;
	public static double maxlong = 34.56762;
	public static double pagexmax = 850;
	public static double pagexmin = 0;
	public static double pageymax = 650;
	public static double pageymin = 0;
//public static double  r;
//public static String h="";
//	public static  Vertex vertex1=null;
//	public static  Vertex vertex2=null;
	//PriorityQueue<Vertex> minheap = new PriorityQueue<>();
	double[] longti;
	double[] lati;
	// public Circle c2;
	public static int f=0;
	//public  int u=0;
	// here we define 2 variables for the distance and path to put them as final result 
	public static double totalDistance;
	public static String totalPath="";
	//public HBox hb= new HBox();
	Pane  pane= new Pane();
	
	MainPage mainpage = new MainPage();
	StartPage startpage = new StartPage();
	SelectWarin warpage = new SelectWarin();
    Circle [] c;
	Scene scene1 = new Scene(mainpage.getMaingroup(), 1250, 650);
	Scene scene2 = new Scene(startpage.getGroup(), 1250, 650);
    Scene scene3 = new Scene(warpage.getWarborder(),600,400);
	public  ArrayList<Vertex> ver = new ArrayList<>();
	
	public   HashMap<String, Vertex> cityinformation = new HashMap<>();
	
	//HashMap<String,Double> distance= new HashMap<>();
	//HashMap<Vertex,Boolean> Known=new HashMap<>();
	//HashMap<Circle,String> c2;
	Image m = new Image("file:///C:/Users/Ehab/eclipse-workspace/Project3Dijkstra/src/application/red1.png");
		ImageView mg = new ImageView(m);
		int u=0;
		Image m2 = new Image("file:///C:/Users/Ehab/eclipse-workspace/Project3Dijkstra/src/green%20res.png");
		ImageView mg2 = new ImageView(m2);
		
	//Circle[] circles ;
	ObservableList<String> listsource = FXCollections.observableArrayList();
	//public   Circle[]  circles;
	@Override
	public void start(Stage primaryStage) {
		try {
			stage1.setScene(scene1);
			stage1.show();
			mg.setFitWidth(50);
			mg.setFitHeight(50);
			mg2.setFitWidth(37);
			mg2.setFitHeight(50);
			
			mainpage.getStartbutton().setOnAction(e -> {
				File file1 = new File("C:\\Users\\Ehab\\eclipse-workspace\\Project3Dijkstra\\src\\Map");
				try (Scanner scan = new Scanner(file1)) {

					if (scan.hasNextLine()) {
						String firstLine = scan.nextLine();
						System.out.println("First Line: " + firstLine);
						String[] tokenss = firstLine.split(":");

						// Ensure that there are at least two tokens before accessing them
						if (tokenss.length == 2) {
							int value1 = Integer.parseInt(tokenss[0].trim());
							int value2 = Integer.parseInt(tokenss[1].trim());
							// Process the separated values
							longti = new double[value1];
							lati = new double[value1];

							System.out.println("Value 1: " + value1);
							System.out.println("Value 2: " + value2);
						} else {
							System.out.println("Invalid format for the first line.");
						}
						// Process the rest of the lines
						while (scan.hasNextLine()) {
							u++;
							// System.out.println(y);
							String s = scan.nextLine();
							String[] tokens = s.split(":");

							if (tokens.length > 2) {
								//u++;
								double x = CalculateX(Double.parseDouble(tokens[2]));
								double y = CalculateY(Double.parseDouble(tokens[1]));
							//	System.out.println("  " + tokens[0] + "  " + tokens[1] + "   " + tokens[2]);
								if(tokens[0].contains("Cross")) {
									Vertex v =new Vertex(tokens[0].trim(), Double.parseDouble(tokens[1]),
											Double.parseDouble(tokens[2]),x,y,false,null);
									cityinformation.put(v.getCityname(), v);
									ver.add(v);
									// cityinformation.put(tokens[0].trim(),new Vertex(tokens[0],Double.parseDouble(tokens[2]),Double.parseDouble(tokens[1]),x+5,y+5.6,false,null));
								}
								else {
								
								Vertex v =new Vertex(tokens[0].trim(), Double.parseDouble(tokens[1]),
										Double.parseDouble(tokens[2]),x,y,false,null);
								cityinformation.put(v.getCityname(), v);
								ver.add(v);
								
							//	 cityinformation.put(tokens[0].trim(),new Vertex(tokens[0],Double.parseDouble(tokens[2]),Double.parseDouble(tokens[1]),x+5,y,false,null));
								}
							} else if (tokens.length == 2) {
							//	System.out.print("ehabbb ana hoon");
								for(int i=0;i<ver.size();i++) {
								if(ver.get(i).getCityname().trim().compareToIgnoreCase(tokens[0].trim())==0) {
									for(int j=0;j<ver.size();j++) {
										if(ver.get(j).getCityname().trim().compareToIgnoreCase(tokens[1].trim())==0) {
											Vertex a = ver.get(i);
											Vertex b = ver.get(j);
											
											double long1=a.getLongitude();
											double long2=b.getLongitude();
											double lat1=a.getLatitude();
											double lat2=b.getLatitude();
											a.getEdge().add(new Edge(a,b,Distance(long1,long2,lat1,lat2)));
											cityinformation.get(a.getCityname()).getEdge().add(new Edge(a,b,Distance(long1,long2,lat1,lat2)));
//											System.out.println("-========================================================================");
//											System.out.println("Ver one : "+ver.get(i).getCityname() +" Ver two : "+ver.get(j).getCityname()+" The distance is : "+ver.get(i)+" .");
//											System.out.println("-========================================================================");
										}
									}
								}
								
							}
								}
//							System.out.println("-========================================================================");
//							System.out.println("-========================================================================");
//							System.out.println("-========================================================================");
//							System.out.println("-========================================================================");
//							for (int i = 0; i < ver.size(); i++) {
//								System.out.println(ver.get(i).ttoString());
//							}
//							System.out.println("**********************************************************************************************");
//							
						
						}
//							if(!(ver.get(i).getCityname().trim().equals(tokens[1].trim()))) {
//								System.out.println("val u "+u);
//							}
//							else {
								//++u;
//							}
//					
							//}

						}
					
//					for(int y=0;y<ver.size();y++) {
//						System.out.println(ver.get(y).ttoString()+" the num of edges is   "+ver.get(y).getEdge().size() + "dis  " +ver.get(y).getDistance());
//					}
//
//					for (Map.Entry<String, Vertex> entry : cityinformation.entrySet()) {
//			            System.out.println("--> Key: " + entry.getKey() + ", Value: " + entry.getValue()+" the distance is : "+ entry.getValue().getDistance()+" the visit is "+ entry.getValue().isKnown()+" the prev is +: "+  entry.getValue().getPreviousvertex()+" the edge size is "+ entry.getValue().getEdge().size() );
//			        }
//					System.out.println("---------------------------------");
//					System.out.println("The size of map is "+ cityinformation.size());
//					System.out.println("---------------------------------");
//					System.out.println("The size of aarya is "+ ver.size());
//					for (int k = 0; k < cityinformation.size(); k++) {
//						System.out.println("The city name is : "+"the num of edges "+cityinformation.get(ver.get(k).getCityname()).getEdge().size());
////					   for(int i=0 ;i<ver.get(k).getEdge().size();i++) {
////						   System.out.println("The edges is : "+ver.get(k).getEdge().get(i).getTwo().getCityname());
////					   }
//					}
					
//					 Vertex ver1= ver.get(1);
//					 Vertex ver2= ver.get(2);
//					 double long1=ver1.getLongitude();
//						double long2=ver2.getLongitude();
//						double lat1=ver1.getLatitude();
//						double lat2=ver2.getLatitude();
					
					// System.out.println("The u val : "+u);
					 
				//	int b=0;
				//	c = new Circle[ver.size()];
					//c2= new HashMap<>();
					 Circle [] circles= new Circle[ver.size()];
					 HashMap<Circle,String> ser= new HashMap<>();
					for (int k = 0; k < ver.size(); k++) {
						if (ver.get(k).getCityname().contains("Cross")) {
							Circle cir = new Circle(ver.get(k).getX(), ver.get(k).getY(), 0.5, Color.BLACK.brighter().brighter());
							circles[k]=cir;
							ScaleTransition scaleTransitiony = new ScaleTransition(Duration.seconds(3), cir);
							scaleTransitiony.setFromX(0.0);
							scaleTransitiony.setFromY(0.0);
							scaleTransitiony.setToX(1.0);
							scaleTransitiony.setToY(1.0);
							scaleTransitiony.playFromStart();
						//	pane.getChildren().addAll(circles[k]);
						} else {
							listsource.add(ver.get(k).getCityname());
							 Circle r= new Circle (ver.get(k).getX(),ver.get(k).getY(),2, Color.BLACK);
							 circles[k]=r;
							// c[b]=r;
							// b++;
							 ser.put(circles[k], ver.get(k).getCityname());
							Text t = new Text(ver.get(k).getCityname());
							t.setFont(Font.font("BankGothic LT BT",FontWeight.BLACK ,FontPosture.ITALIC, 7));
							ScaleTransition scaleTransitiony = new ScaleTransition(Duration.seconds(4), r);
							scaleTransitiony.setFromX(0.0);
							scaleTransitiony.setFromY(0.0);
							scaleTransitiony.setToX(1.0);
							scaleTransitiony.setToY(1.0);
							scaleTransitiony.playFromStart();

							ScaleTransition scaleTransitiony1 = new ScaleTransition(Duration.seconds(4), t);
							scaleTransitiony1.setFromX(0.0);
							scaleTransitiony1.setFromY(0.0);
							scaleTransitiony1.setToX(1.0);
							scaleTransitiony1.setToY(1.0);
							scaleTransitiony1.playFromStart();
							t.setLayoutX(ver.get(k).getX()-5);
							t.setLayoutY(ver.get(k).getY()-5);
							pane.getChildren().addAll(circles[k],t);
						}
				
						
						
					}
                  startpage.getGroup().getChildren().add(pane);
                  for(Circle circs: circles) {
                	 
         				circs.setOnMouseClicked(ec->{
         					 try {
         					if(f==0) {
         						pane.getChildren().remove(mg);
         					String citynames= ser.get(circs);
         					Vertex v= cityinformation.get(citynames);
         					startpage.getCombo1().setValue(citynames);
         					startpage.getCombo1().getSelectionModel().select(citynames);
         					circs.setFill(Color.RED);
         					mg.setLayoutX(v.getX()-25);
         					mg.setLayoutY(v.getY()-48);
         					pane.getChildren().add(mg);
         					f=1;
         					}
         					else if(f==1){
         						pane.getChildren().remove(mg2);
         						String citynames= ser.get(circs);
         						Vertex v= cityinformation.get(citynames);
         						startpage.getCombo2().setValue(citynames);
         						startpage.getCombo2().getSelectionModel().select(citynames);
         						circs.setFill(Color.GREEN.brighter());
             					mg2.setLayoutX(v.getX()-19);
             					mg2.setLayoutY(v.getY()-47);
             					pane.getChildren().add(mg2);
         						f=0;
         					}
         					 }
         				
         				catch(Exception ex) {
         					System.out.println("ehaboooooo");
         				}
         				});
         			}
		
					FXCollections.sort(listsource);

					startpage.getCombo1().setItems(listsource);
					startpage.getCombo2().setItems(listsource);

				}
				

				catch (IOException ex) {
					System.out.println("Theres something wrong on reading the file !" + ex.getMessage());
				}
				stage2.setScene(scene2);
				stage2.show();
				stage1.close();
			});
			
			 
			
		
		
			startpage.getRun().setOnAction(e->{
			String city1=startpage.getCombo1().getValue();
			String city2=startpage.getCombo2().getValue();
			
			
				if(city1==null || city2==null) {
				warpage.getMsgtxt().setText("Theres an Error Message From The Program ,"+"\n"+"Please select both source and destination cities."+"\n"+"Empty fields are not allowed."+"\n"+"Thank You !!");
				stage3.setScene(scene3);
				stage3.show();
				System.out.println("empty string");
				f=0;
				}
				else 
					if(city1.equals(city2)) {
						totalPath="NO PATH ";
						totalDistance=0;
						startpage.getTextarea().setText(totalPath);
						String dis = totalDistance+" Km";
						startpage.getTextfield().setText(dis);
						}
			else {
				 city1=startpage.getCombo1().getValue().trim();
				 city2=startpage.getCombo2().getValue().trim();
				 System.out.println("wa7addddddd "+city1);
				 System.out.println("thaniiiiiiiiii "+city2);
				 if(cityinformation.containsKey(city1) && cityinformation.containsKey(city2)) {
					 System.out.println("yes");
					Vertex vertex1= cityinformation.get(city1);
						System.out.println("The city name "+vertex1.getCityname());
						System.out.println(vertex1.getLatitude());
						System.out.println(vertex1.getLongitude());
						System.out.println(vertex1.getX());
						System.out.println(vertex1.getY());
						System.out.println(vertex1.getDistance());
						System.out.println("The edge num 1 "+vertex1.getEdge().size());
						System.out.println("------------------------");
						Vertex vertex2=cityinformation.get(city2);
						System.out.println("The city name "+vertex2.getCityname());
						System.out.println(vertex2.getLatitude());
						System.out.println(vertex2.getLongitude());
						System.out.println(vertex2.getX());
						System.out.println(vertex2.getY());System.out.println(vertex1.getY());
						System.out.println("The edge num 2 "+vertex2.getEdge().size());
						Dijkstras(vertex1, vertex2);
						startpage.getTextarea().setText(totalPath);
						totalPath="";
						String resdis=String.valueOf(vertex2.getDistance());
						resdis=resdis+"  KM";
						startpage.getTextfield().setText(resdis);
						vertex1=null;
						vertex2=null;
				 }
				 else {
					 boolean a = cityinformation.containsKey(city1);
				     boolean b =cityinformation.containsKey(city2);
				     if(a==false&& b==true) {
				    	 warpage.getMsgtxt().setText("You Have a Message From The Program ! :"+"\n" +"we Have an Problem in Source City ."+"\n"+"The City : ( "+city1+" ) Does not exists !"+"\n"+"The Destination City : "+city2+" is Exists ! "+"\n"+" So Please Enter Again The Source City ! "+"\n"+" Thank You .");
				    	     startpage.getCombo1().setValue(null);
				    	     f=0;
							stage3.setScene(scene3);
							stage3.show();
				     }
				     else if(a==true && b==false) {
				    	 warpage.getMsgtxt().setText("You Have a Message From The Program ! :"+"\n" +"we Have an Problem in Destination City ."+"\n"+"The City : "+city1+" Is Exists !"+"\n"+"The Destination City : ( "+city2+" ) Does Not Exists ! "+"\n"+" So Please Enter Again The Destination City ! "+"\n"+" Thank You .");
			    	     startpage.getCombo2().setValue(null);
			    	     f=1;
						stage3.setScene(scene3);
						stage3.show();
				     }
				     else {
				    	 warpage.getMsgtxt().setText("You Have a Message From The Program ! :"+"\n" +"we Have an Problem in Source and  Destination Cities  ."+"\n"+"The City : ( "+city1+" ) Does Not Exists !"+"\n"+"The Destination City : ( "+city2+" ) Does Not Exists ! "+"\n"+" So Please Enter Again The Source and Destination Cities ! "+"\n"+" Thank You .");
			    	     startpage.getCombo1().setValue(null);
			    	     startpage.getCombo2().setValue(null);
			    	     f=0;
						stage3.setScene(scene3);
						stage3.show();
				     }
				 }
			}
			
			
			});	
				
					
			warpage.getOkbutton().setOnAction(e->{
				stage3.close();
			});
			
			startpage.getMainbutton().setOnAction(e -> {
				// its like clear not go to the main page
				// remember to do button for mainpage
			});
			
			
			startpage.getCombo1().setOnAction(e->{
				f=0;
			
				if(f==0) {
				try {
//					pane.getChildren().clear();
//					for(int i=0;i<c.length;i++) {
//					Text t = new Text();
//					t.setText(c2.get(c[i]));
//					Vertex v= cityinformation.get(c2.get(c[i]));
//					t.setLayoutX(v.getX()+5);
//					t.setLayoutY(v.getY());
//					pane.getChildren().addAll(c[i],t);
//					}
//					String citynam= startpage.getCombo1().getValue();
//					Vertex v2 = cityinformation.get(citynam);
//					Image m1 = new Image("file:///C:/Users/Ehab/eclipse-workspace/Project3Dijkstra/src/application/221-2210673_logo-location-vector-png.png");
//					ImageView mg1 = new ImageView(m1);
//					mg1.setFitWidth(50);
//					mg1.setFitHeight(50);
//					mg1.setLayoutX(v2.getX()-25);
//					mg1.setLayoutY(v2.getY()-48);
//					pane.getChildren().add(mg1);
					
				pane.getChildren().remove(mg);
			String cityname= startpage.getCombo1().getValue();
			Vertex v = cityinformation.get(cityname);
				mg.setLayoutX(v.getX()-25);
				mg.setLayoutY(v.getY()-48);
				pane.getChildren().add(mg);
				}
				catch(Exception ex) {
					System.out.println("null ya ehab ");
				}
				
				}
				f=1;
			});
			
			startpage.getCombo2().setOnAction(e->{
				f=1;
				if(f==1) {
				try {
					pane.getChildren().remove(mg2);
				String cityname= startpage.getCombo2().getSelectionModel().getSelectedItem();
				Vertex v = cityinformation.get(cityname);
					mg2.setLayoutX(v.getX()-19);
					mg2.setLayoutY(v.getY()-47);
					pane.getChildren().add(mg2);
				}
				catch(Exception ex) {
					System.out.println("null 2 ya ehab ");
				}
				}
				f=0;
			});
			
			startpage.getClearall().setOnAction(e->{
				try {	
					ver.clear();
					cityinformation.clear();
					File file1 = new File("C:\\Users\\Ehab\\eclipse-workspace\\Project3Dijkstra\\src\\Map");
					try (Scanner scan = new Scanner(file1)) {

						if (scan.hasNextLine()) {
							String firstLine = scan.nextLine();
							System.out.println("First Line: " + firstLine);
							String[] tokenss = firstLine.split(":");

							// Ensure that there are at least two tokens before accessing them
							if (tokenss.length == 2) {
								int value1 = Integer.parseInt(tokenss[0].trim());
								int value2 = Integer.parseInt(tokenss[1].trim());
								// Process the separated values
								longti = new double[value1];
								lati = new double[value1];

								System.out.println("Value 1: " + value1);
								System.out.println("Value 2: " + value2);
							} else {
								System.out.println("Invalid format for the first line.");
							}
							// Process the rest of the lines
							while (scan.hasNextLine()) {
								u++;
								// System.out.println(y);
								String s = scan.nextLine();
								String[] tokens = s.split(":");

								if (tokens.length > 2) {
									//u++;
									double x = CalculateX(Double.parseDouble(tokens[2]));
									double y = CalculateY(Double.parseDouble(tokens[1]));
								//	System.out.println("  " + tokens[0] + "  " + tokens[1] + "   " + tokens[2]);
									if(tokens[0].contains("Cross")) {
										Vertex v =new Vertex(tokens[0].trim(), Double.parseDouble(tokens[1]),
												Double.parseDouble(tokens[2]),x,y,false,null);
										cityinformation.put(v.getCityname(), v);
										ver.add(v);
										// cityinformation.put(tokens[0].trim(),new Vertex(tokens[0],Double.parseDouble(tokens[2]),Double.parseDouble(tokens[1]),x+5,y+5.6,false,null));
									}
									else {
									
									Vertex v =new Vertex(tokens[0].trim(), Double.parseDouble(tokens[1]),
											Double.parseDouble(tokens[2]),x,y,false,null);
									cityinformation.put(v.getCityname(), v);
									ver.add(v);
									
								//	 cityinformation.put(tokens[0].trim(),new Vertex(tokens[0],Double.parseDouble(tokens[2]),Double.parseDouble(tokens[1]),x+5,y,false,null));
									}
								} else if (tokens.length == 2) {
								//	System.out.print("ehabbb ana hoon");
									for(int i=0;i<ver.size();i++) {
									if(ver.get(i).getCityname().trim().compareToIgnoreCase(tokens[0].trim())==0) {
										for(int j=0;j<ver.size();j++) {
											if(ver.get(j).getCityname().trim().compareToIgnoreCase(tokens[1].trim())==0) {
												Vertex a = ver.get(i);
												Vertex b = ver.get(j);
												
												double long1=a.getLongitude();
												double long2=b.getLongitude();
												double lat1=a.getLatitude();
												double lat2=b.getLatitude();
												ver.get(i).getEdge().add(new Edge(a,b,Distance(long1,long2,lat1,lat2)));
												cityinformation.get(a.getCityname()).getEdge().add(new Edge(a,b,Distance(long1,long2,lat1,lat2)));
											//	System.out.println("Ver one : "+ver.get(i).getCityname() +" Ver two : "+ver.get(j).getCityname()+" The distance is : "+Distance(long1,long2,lat1,lat2)+" .");
											}
										}
									}
									
								}
									}
								
								
								
								
							
							}
					  //  setAllVerticesUnvisited(cityinformation);
			         //  setAllVerticesPreviousnull(cityinformation);
					totalPath="";
				startpage.getTextarea().setText(null);
				startpage.getTextfield().setText(null);
				startpage.getTextfield().clear();
				startpage.getCombo1().setValue(null);
				startpage.getCombo2().setValue(null);
				startpage.getCombo1().getSelectionModel().clearSelection();
				startpage.getCombo2().getSelectionModel().clearSelection();
				pane.getChildren().clear();
				startpage.getGroup().getChildren().remove(pane);
				 Circle [] circles= new Circle[ver.size()];
				 HashMap<Circle,String> ser= new HashMap<>();
				for (int k = 0; k < ver.size(); k++) {
					if (ver.get(k).getCityname().contains("Cross")) {
						Circle cir = new Circle(ver.get(k).getX(), ver.get(k).getY(), 0.5, Color.BLACK.brighter().brighter());
						circles[k]=cir;
						ScaleTransition scaleTransitiony = new ScaleTransition(Duration.seconds(3), cir);
						scaleTransitiony.setFromX(0.0);
						scaleTransitiony.setFromY(0.0);
						scaleTransitiony.setToX(1.0);
						scaleTransitiony.setToY(1.0);
						scaleTransitiony.playFromStart();
					//	pane.getChildren().addAll(circles[k]);
					} else {
						//listsource.add(ver.get(k).getCityname());
						 Circle r= new Circle (ver.get(k).getX(),ver.get(k).getY(),2, Color.BLACK.darker());
						 circles[k]=r;
						 ser.put(r, ver.get(k).getCityname());
						Text t = new Text(ver.get(k).getCityname());
						t.setFont(Font.font("BankGothic LT BT",FontWeight.BLACK ,FontPosture.ITALIC, 7));
						ScaleTransition scaleTransitiony = new ScaleTransition(Duration.seconds(4), r);
						scaleTransitiony.setFromX(0.0);
						scaleTransitiony.setFromY(0.0);
						scaleTransitiony.setToX(1.0);
						scaleTransitiony.setToY(1.0);
						scaleTransitiony.playFromStart();

						ScaleTransition scaleTransitiony1 = new ScaleTransition(Duration.seconds(4), t);
						scaleTransitiony1.setFromX(0.0);
						scaleTransitiony1.setFromY(0.0);
						scaleTransitiony1.setToX(1.0);
						scaleTransitiony1.setToY(1.0);
						scaleTransitiony1.playFromStart();
						t.setLayoutX(ver.get(k).getX()-5);
						t.setLayoutY(ver.get(k).getY()-5);
						pane.getChildren().addAll(circles[k],t);
					}	
				}
				
              startpage.getGroup().getChildren().addAll(pane);
              f=0;
              for(Circle circs: circles) {
     				circs.setOnMouseClicked(ec->{
     					try {
     					if(f==0) {
     						System.out.println(ser.get(circs));
     						pane.getChildren().remove(mg);
     					String citynames= ser.get(circs);
     					System.out.println("ser one is "+citynames);
     					Vertex v=cityinformation.get(citynames);
     					System.out.println("heheee 1");
     					//System.out.println("city 1"+citynames);
     					startpage.getCombo1().setValue(citynames);
     					startpage.getCombo1().getSelectionModel().select(citynames);
     					circs.setFill(Color.RED);
     					mg.setLayoutX(v.getX()-25);
     					mg.setLayoutY(v.getY()-48);
     					pane.getChildren().add(mg);
     					f=1;
     					}
     					else if(f==1){
     						String citynames= ser.get(circs);
     						pane.getChildren().remove(mg2);
     						System.out.println("ser one is "+citynames);
     						Vertex v=cityinformation.get(citynames);
     						System.out.println("heheee2 ");
         					//System.out.println("city 2"+citynames);
     						startpage.getCombo2().setValue(citynames);
     						startpage.getCombo2().getSelectionModel().select(citynames);
     						circs.setFill(Color.GREEN.brighter());
         					mg2.setLayoutX(v.getX()-19);
         					mg2.setLayoutY(v.getY()-47);
         					pane.getChildren().add(mg2);
     						f=0;
     					}
     					}
     					catch(Exception ex) {
     						System.out.println("Ehabbooooo 2");
     					}
     				});
     			}
              
						}}
				catch(Exception ex) {
					System.out.println("null 3 ya ehab");
					
				}
					}
					catch(Exception ex) {
						System.out.println("null 3 ya ehab");
						
					}
				
			});

	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static double CalculateX(double longx) {
		double resX;
		resX = ((((longx - minlong) * (pagexmax)) / (maxlong - minlong)) + pagexmin);
		return resX;
	}

	private static double CalculateY(double laty) {
		double resY;
		resY = ((((laty - minlat) * (pageymax)) / (maxlat - minlat)) + pageymin);
		return resY;
	}

	public static double Distance(double long1, double long2, double lat1, double lat2) {
		// first we define the radius of the earth
		final double RADIUS = 6371;
		// we convert each of Longti. and Lati. for each vertex to Radians
		double long1Rad = Math.toRadians(long1);
		double long2Rad = Math.toRadians(long2);
		double lat1Rad = Math.toRadians(lat1);
		double lat2Rad = Math.toRadians(lat2);

		// now we take the delta for the long. and lat.
		double deltalat = lat2Rad - lat1Rad;
		double deltalong = long2Rad - long1Rad;


		// now we calculate the distance!
		double distance = Math.sin(deltalat / 2) * Math.sin(deltalat / 2)
				+ Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.sin(deltalong / 2) * Math.sin(deltalong / 2);
		double res = 2 * Math.atan2(Math.sqrt(distance), Math.sqrt(1 - distance));

		// here we multiply by the radius of the earth to get the ditance in kilometers
		return RADIUS * res;
	}
	
	
	public void Dijkstras(Vertex s,Vertex d) {
		//int k=0;
		
//		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//		  for (Map.Entry<String,Vertex> entry : cityinformation.entrySet()) {
//			  
//           System.out.println("The previous is : "+entry.getKey()+" The visit is  : "+entry.getValue().isKnown()+" The previous path is : "+entry.getValue().getPreviousvertex());
//          }
//		  System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		//where s is source and d is destination (target).
		// first when we start the source(the start city) the cost of it is equal zero
		s.setDistance(0);
		PriorityQueue<Vertex> minheap = new PriorityQueue<>();
		minheap.add(s);
		 // first we want to add the source s to the heap (priority queue)
		
		//System.out.println("nshallah sa777 "+s.getEdge().size());
		
		while(!minheap.isEmpty()) {
			
			Vertex vert = minheap.poll();
			System.out.println("vert city name "+vert.getCityname());
			System.out.println("vert visit  bef "+vert.isKnown());
			 
			System.out.println("vert visit AF "+vert.isKnown());
			if(vert.getCityname().equals(d.getCityname())) {
				
				System.out.println("out of empty ");
				break; 
				}
			
			for(Edge edgelinked:vert.getEdge()) {
				
				Vertex verte=edgelinked.getTwo();
				if(!verte.isKnown()) {
					System.out.println("-------------------");
					double wdist=edgelinked.getCost();
					double distancewithnew=vert.getDistance()+ wdist;
					if(distancewithnew<verte.getDistance()) {
						verte.setDistance(distancewithnew);
						System.out.println("the verte previous is "+verte.getPreviousvertex());
						verte.setPreviousvertex(vert);
						System.out.println("the verte previous af "+verte.getPreviousvertex().getCityname());
						minheap.add(verte);
					}
				}
				
			}
			
	
		}
		
	   List<Vertex> pathver= new ArrayList<>();
			Vertex vertexx= d;
		while(vertexx!=null) {
			pathver.add(vertexx);
			vertexx=vertexx.getPreviousvertex();
		}
		Collections.reverse(pathver);
		totalPath="";
           for(int i=0;i<pathver.size();i++) {
        	   totalPath=totalPath+pathver.get(i).getCityname()+"\n";
           }
           for (int i = 0; i < pathver.size()-1; i++) {
			Vertex v1=pathver.get(i);
			System.out.println("---------++++++++++++++++___________+++++++++++");
			System.out.println("path ver city1"+v1.getCityname());
			Vertex v2=pathver.get(i+1);
			System.out.println("hereeee 222"+v2.getCityname());
			System.out.println("---------++++++++++++++++___________+++++++++++");
			Line line = new Line(v1.getX(),v1.getY(),v2.getX(),v2.getY());
			 line.setStrokeWidth(2.0);
			 line.setStroke(Color.BLACK);
			line .setFill(Color.RED);
//          ImageView mg3= new ImageView("file:///C:/Users/Ehab/eclipse-workspace/Project3Dijkstra/src/ball.png");
//          mg3.setFitHeight(30);
//          mg3.setFitWidth(30);
//          mg3.setLayoutX(v1.getX());
//          mg3.setLayoutY(v1.getY());
//          ImageView mg4= new ImageView("file:///C:/Users/Ehab/eclipse-workspace/Project3Dijkstra/src/ball.png");
//          mg4.setFitHeight(30);
//          mg4.setFitWidth(30);
//          mg4.setLayoutX(v2.getX()-5);
//          mg4.setLayoutY(v2.getY());
			pane.getChildren().add(line);
			//pane.getChildren().add(mg3);
			//pane.getChildren().add(mg4);
			
				
		}
        //   setAllVerticesUnvisited(cityinformation);
        //   setAllVerticesPreviousnull(cityinformation);
           
           
	}
	 private static void setAllVerticesUnvisited(Map<String,Vertex> cityinformation) {
         for (Map.Entry<String,Vertex> entry : cityinformation.entrySet()) {
        	 entry.getValue().setVisit(false);
         }
	 }
         private static void setAllVerticesPreviousnull(Map<String,Vertex> cityinformation) {
             for (Map.Entry<String,Vertex> entry : cityinformation.entrySet()) {
 
                 entry.getValue().setPreviousvertex(null);
             }
	 }
        
       

	public static void main(String[] args) {
		launch(args);
	}
}

