package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ThreadPing extends Thread{
	private int num ;
	public ThreadPing(int num) {
		this.num = num;
		}
	public void run() {
		ping();
	}
	private void ping() {
		String processo="";
		 if (num == 1 ) {
			 processo = "ping -4 -c 10 www.uol.com.br";
		 }else if(num==2){
			 processo = "ping -4 -c 10 www.terra.com.br";
		 }else if(num==3) {
			 processo = "ping -4 -c 10 www.google.com.br";
		 }
		Process ping;
		try {
			ping =Runtime.getRuntime().exec(processo);
			InputStream fluxo = ping.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha;
			String ultima = "";
			String server= "";
            while ((linha = buffer.readLine()) != null) {
                ultima = linha;
                if(processo.contains("google")) {
    				server = "google";
    			}else if (processo.contains("uol")) {
    				server = "uol";
    			}else if(processo.contains("terra")) {
    				server = "terra";
    			
    		}
                if (linha.contains("time")) {
                    System.out.println(server + ": " + linha);
                }
    			linha = buffer.readLine();
    		}
            
            buffer.close();
            leitor.close();
            fluxo.close();
            
                String[] split = ultima.split("/");
                System.out.println(server+ ": Média = " + split[split.length - 3]);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }}}
//		try {
//		ping =Runtime.getRuntime().exec(processo);
//		InputStream fluxo = ping.getInputStream();
//		InputStreamReader leitor = new InputStreamReader(fluxo);
//		BufferedReader buffer = new BufferedReader(leitor);
//		String linha = buffer.readLine();
//		
//		while(linha !=null) {
//			if(processo.contains("google")) {
//				linha.split("time");
//				System.out.println("google: "+linha);
//			}else if (processo.contains("uol")) {
//				linha.split("time");
//				System.out.println("uol "+linha);
//			}else if(processo.contains("terra")) {
//				linha.split("time");
//				System.out.println("terra: "+linha);	
//			
//		}
//			linha = buffer.readLine();
//		}
//		buffer.close();
//		leitor.close();
//		fluxo.close();
//	}catch(IOException e){
//		e.printStackTrace();
//	}
//		}
//}
