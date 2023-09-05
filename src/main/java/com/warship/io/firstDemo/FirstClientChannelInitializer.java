package com.warship.io.firstDemo;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class FirstClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        //这个地方的 必须和服务端对应上。否则无法正常解码和编码
        //解码和编码 我将会在下一节为大家详细的讲解。暂时不做详细的描述

        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());

        // 我们自己的handler
        pipeline.addLast("handler", new HelloWorldClientHandler());
    }
}
