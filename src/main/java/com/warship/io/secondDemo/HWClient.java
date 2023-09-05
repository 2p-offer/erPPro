package com.warship.io.secondDemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class HWClient {
    private  int port;
    private  String address;

    public HWClient(int port, String address) {
        this.port = port;
        this.address = address;
    }

    public void start(){
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new SecondClientChannelInitializer());

        try {
            ChannelFuture future = bootstrap.connect(address,port).sync();
            future.channel().writeAndFlush("Hello Netty Server ,I am a common client");
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        HWClient client = new HWClient(7799,"127.0.0.1");
        client.start();
    }
}
