node {
    def foo = 'bar'

    stage ('Checkout') {
        checkout scm
    }

    stage ('Hello') {
        echo "Hello $foo!"
        echo "Where am I ?"
        sh "pwd"
    }
}