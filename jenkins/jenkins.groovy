job('jenkins1') {
    scm {
        git('git://github.com/preetesh33/docker.git') { node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('Preetesh Sharma')
            node / gitConfigEmail('preetesh_sharma@hotmail.com')
        }
    }
}

job('jenkins1') {
    steps {
        dockerBuildAndPublish {
            repositoryName('preetesh/docker-demo')
            tag('${BUILD_TIMESTAMP}-${GIT_REVISION,length=7}')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
