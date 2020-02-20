#!/usr/bin/env groovy

properties([
        buildDiscarder(logRotator(daysToKeepStr: '5', numToKeepStr: '3')),
])

podTemplate(label: 'sanity-build',
        containers: [
                containerTemplate(name: 'build', image: 'python:3.7', ttyEnabled: true, command: 'cat')]
) {

    node('sanity-build') {
        stage('get project') {
            checkout scm
        }

        stage('Deploy') {
            
                python3 hello.py
        }

    }
}
