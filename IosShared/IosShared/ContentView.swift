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
    
    @State var content = "No data"
    
    var body: some View {
        VStack{
            
            Button(action: {
               ApolloCoroutinesRepositoryKt.createRemoteRepoGraphQl().fetchRepositoriesCB(success: { data in
                   print("======================= BEGIN =========================")
                self.content = "\(data)"
                   print(data)
                   print("======================= END =========================")
               }, error: { error in print(error)})
            }){
                Text("Send request")
                    .font(.system(size: 30))
                    .fontWeight(.heavy)
                    .foregroundColor(.black)
                    .padding(.horizontal)
            }
            
            Text(content)
            
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
