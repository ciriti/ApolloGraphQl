//
//  ContentView.swift
//  IosShared
//
//  Created by Carmelo Iriti on 24.04.20.
//  Copyright © 2020 Carmelo Iriti. All rights reserved.
//

import SwiftUI
import kmpdata

struct ContentView: View {
    var body: some View {
        VStack{
            Text("Hello, World!")
            Button(action: {
                print("========= Loading... =========")
                ApolloCoroutinesRepositoryKt.createRemoteRepoGraphQl().fetchUserCB(id: "1", success: { data in
                    print(data)
                    print("========= Done! =========")
                }, error: { error in print(error)})
            }){
                Text("Call")
                .font(.system(size: 50))
                .fontWeight(.heavy)
                .foregroundColor(.white)
                .padding(.horizontal)
            }
            .background(Color.green)
            Button(action: {
                print("test")
            }){
                Text("Play")
                    .font(.system(size: 50))
                    .fontWeight(.heavy)
                    .foregroundColor(.white)
                    .padding(.horizontal)
            }
            .background(Color.red)
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
