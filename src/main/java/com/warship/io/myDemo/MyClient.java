package com.warship.io.myDemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {

    private  int port;
    private  String address;

    public MyClient(int port,String address) {
        this.port = port;
        this.address = address;
    }

    public void start(){
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new MyClientChannelInitializer());

        try {
            ChannelFuture future = bootstrap.connect(address,port).sync();
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        MyClient client = new MyClient(7766,"127.0.0.1");
        client.start();
    }
}
